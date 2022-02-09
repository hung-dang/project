package LHU.project.controller.functions;

import LHU.project.entities.Creator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractController {

    @GetMapping(value = "/contract")
    public String contract(Model model){
        Creator creator
                =new Creator();
        //
        model.addAttribute("creator",creator);
        return "Creator.html";
    }
}
