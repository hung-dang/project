package LHU.project.controller.functions;

import LHU.project.entities.FeedBack;
import LHU.project.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Date;

@Controller
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @GetMapping(value = "/feedback")
    public String feedBack(Model model){
        FeedBack feedBack=new FeedBack();
        model.addAttribute("feedback",feedBack);
        return "FeedBack";
    }

    @PostMapping(value = "/feedback")
    public String saveRegister(Model model,
                               @ModelAttribute("feedback") FeedBack feedBack)
            throws IllegalStateException, IOException {
        // save
        feedBack.setCreatedAt(new Date());
        Byte status=0;
        feedBack.setStatus(status);
        feedBackService.saveOrUpdate(feedBack);
        model.addAttribute("mess", "FeedBack Success");
        model.addAttribute("feedback", new FeedBack());
        return "FeedBack";
    }

}
