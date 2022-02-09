package LHU.project.controller.functions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LichHoc {

    @GetMapping(value = "/lichhoc")
    public String getLichHoc(){

        return "lichhoc";
    }
}
