package pl.marczykm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcin on 23.07.15.
 */
@Controller
public class SecurityController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
