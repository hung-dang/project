package LHU.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests() // bắt đầu cấu hình: tất cả các requests từ
                // trình duyệt đều được bắt trong hàm này

                // cho phép các request static resources không bị ràng buộc(permitAll)
                .antMatchers("/css/**", "/js/**", "/uploads/**", "/datetimepicker/**", "images/**","/register").permitAll()

                // các request kiểu: "/admin/" là phải đăng nhập (authenticated)
                // tất cả request đều phải login: /**
                .antMatchers("/**").hasAnyAuthority("ADMIN", "STUDENT"
                        )
                .and()


                // cấu hình trang đăng nhập
                // /login là 1 action
                .formLogin().loginPage("/login").loginProcessingUrl("/perform_login").defaultSuccessUrl("/home")
                .failureUrl("/login?login_error=true")

                .permitAll()

                .and()

                // cấu hình cho phần logout
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true)
                .deleteCookies("JSESSIONID").permitAll();

        http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
