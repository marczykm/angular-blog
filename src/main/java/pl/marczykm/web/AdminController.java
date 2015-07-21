package pl.marczykm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcin on 21.07.15.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String index(){
        return "index";
    }
}
