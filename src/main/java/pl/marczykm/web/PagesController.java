package pl.marczykm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcin on 21.07.15.
 */
@Controller
public class PagesController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/admin")
    public String adminMainPage(){
        return "admin";
    }
}
