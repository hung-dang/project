package LHU.project.controller.register;

import LHU.project.entities.Account;
import LHU.project.entities.AccountRoles;
import LHU.project.entities.Roles;
import LHU.project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "register")
    public String getRegister(Model model){
        Account account =new Account();
        model.addAttribute("register",account);
        return "register/register.html";
    }

    @PostMapping(value = "/register")
    public String saveRegister(Model model,
                               @ModelAttribute("register") Account account)
            throws IllegalStateException, IOException {
        // tao ma hoa password

        // luu role id v account id vao bang roles_account
        AccountRoles accountRoles = new AccountRoles();
        Roles roles = new Roles();

        if (accountService.isExistAccount(account.getUsername())) {
            model.addAttribute("message", "Account is exsit !");
            model.addAttribute("register", account);
            return "register/register.html";
        }

        if (accountService.isExistEmail(account.getEmail())) {
            model.addAttribute("message", "Email is exsit !");
            model.addAttribute("register", account);
            return "register/register.html";
        }

        if (accountService.isExistPhone(account.getPhoneNumber())) {
            model.addAttribute("message", "PhoneNumber is exsit !");
            model.addAttribute("register", account);
            return "register/register.html";
        }


        if (account.getDateOfBirth().after(new Date())) {
            model.addAttribute("message", "Date of birth can't after now !");
            model.addAttribute("register", account);
            return "register/register.html";
        }

        int current = new Date().getYear();
        int birth = account.getDateOfBirth().getYear();

        if(current - birth <14) {
            model.addAttribute("message", "your age must be greater than 14!");
            model.addAttribute("register", account);
            return "register/register.html";
        }
        if(account.getAccountId()==null) {
            account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
            // mac dinh role id cua user la 4
            roles.setRolesId(2);
            accountRoles.setRoles(roles);
            accountRoles.setAccount(account);
            account.getAccountRoles().add(accountRoles);
            roles.getAccountRoles().add(accountRoles);
        }
        // save
        accountService.saveOrUpdate(account);
        model.addAttribute("mess", "Register Success");
        model.addAttribute("register", new Account());
        return "register/register.html";
    }


}
