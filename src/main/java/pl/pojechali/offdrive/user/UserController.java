package pl.pojechali.offdrive.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @RequestMapping(value = {"/admin/createUser"}, method = RequestMethod.GET)
//    @GetMapping("/admin/createUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "admin/createUser";
    }
    @PostMapping("/admin/createUser")
    public String saveUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "admin/createUser";
        }
        userService.saveUser(user);
        return "admin/login";
    }

//    @GetMapping("/admin")
//    @ResponseBody
//    public String userInfo(@AuthenticationPrincipal UserDetails customUser) {
//        log.info("customUser class {} "
//                , customUser.getClass());
//        return "You are logged as " + customUser;
//    }

}
