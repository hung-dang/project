package LHU.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@org.springframework.context.annotation.Configuration
public class Configuration<InternalResourceViewResolver, ViewResolver> implements WebMvcConfigurer {

private void exposeDirectory(String dirName, ResourceHandlerRegistry registry){
        Path uploadDir= Paths.get(dirName);
        String uploadPath=uploadDir.toFile().getAbsolutePath();

        if(dirName.startsWith("../")){
        dirName=dirName.replace("../","");
        }
        registry.addResourceHandler("/"+dirName+"/**").addResourceLocations("file:/"+uploadPath+"/");
        }


        @Bean
        public JavaMailSender getJavaMailSender() {
                JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
                mailSender.setHost("smtp.gmail.com");
                mailSender.setPort(587);

                mailSender.setUsername("hungdang119900@gmail.com");
                mailSender.setPassword("Hungdang1999");

                Properties props = mailSender.getJavaMailProperties();
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.debug", "true");

                return mailSender;
        }

}
