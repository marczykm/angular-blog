package pl.marczykm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marczykm.service.ConfigurationService;

/**
 * Created by marcin on 21.07.15.
 */
@Controller
public class AngularPageController {

    private ConfigurationService configurationService;

    @Autowired
    public AngularPageController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("blogName", configurationService.getTitle());
        return "index";
    }


}
