package pl.marczykm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcin on 21.07.15.
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @RequestMapping
    public String adminMainPage(){
        return "admin";
    }

    @RequestMapping("/create")
    public String adminCreatePage(){
        return "create";
    }

    @RequestMapping("/posts")
    public String adminManagePostsPage(){
        return "manage";
    }


}
