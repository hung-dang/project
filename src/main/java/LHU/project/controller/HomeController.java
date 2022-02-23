package LHU.project.controller;

import LHU.project.entities.*;
import LHU.project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String getHome(Principal principal){
        String userName=principal.getName();
        Account account=accountService.findByUserName(userName);
        SimpleMailMessage simpleMailMessage =new SimpleMailMessage();
        simpleMailMessage.setTo(account.getEmail());
        simpleMailMessage.setSubject(" THÔNG BÁO ");
        simpleMailMessage.setText("CLass: "+account.getClassName()+"\nRoom: "+"AA"+"\nWeekDay: "+"1231232"+"\nHour: "+"12");
        // Send Message!
        javaMailSender.send(simpleMailMessage);

        return "redirect:/home";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String getHomeHome(){
        return "home";
    }
}
