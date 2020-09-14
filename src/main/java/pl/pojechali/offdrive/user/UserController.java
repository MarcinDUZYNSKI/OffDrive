package pl.pojechali.offdrive.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setEmail("admin@admin.pl");
        user.setPassword("admin");
        user.setFirstName("Zbigniew");
        user.setLastName("Testowy");
//        user.setCreationDate(LocalDate.now());
        userService.saveUser(user);
        return "admin";
    }

//    @GetMapping("/admin")
//    @ResponseBody
//    public String userInfo(@AuthenticationPrincipal UserDetails customUser) {
//        log.info("customUser class {} "
//                , customUser.getClass());
//        return "You are logged as " + customUser;
//    }

}
