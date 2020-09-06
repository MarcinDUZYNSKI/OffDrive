package pl.pojechali.offdrive.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping("/home")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
