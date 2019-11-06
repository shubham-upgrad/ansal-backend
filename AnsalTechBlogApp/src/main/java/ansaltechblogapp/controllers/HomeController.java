package ansaltechblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // A controller is a Component
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
