package pl.pojechali.offdrive.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "admin/login"; //lokalizację pliku widoku
    }
    @RequestMapping(value = {"/perform_login"}, method = RequestMethod.POST)
    public String login2() {
//        System.out.println("nie działa ");
        return "index/index"; //lokalizację pliku widoku
    }

}
