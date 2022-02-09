package LHU.project.controller.logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Logout {
    @GetMapping(value = "/logout")
    public String logout(){

        return "redirect:/login";
    }
}
