package pl.pojechali.offdrive.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
        return "index"; //lokalizację pliku widoku  tylko że to nie dzała bo kontrolęnadrzędną posada Security config

    }
    @RequestMapping("/403")
    public String accessDenied() {
        return "/admin/403";
    }


    @RequestMapping(value="/perform_logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/home";
}

}
