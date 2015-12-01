package pl.marczykm.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcin on 21.07.15.
 */
@Controller
public class AngularPageController {

    @Value("${blog.name}")
    private String blogName;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("blogName", blogName);
        return "index";
    }


}
