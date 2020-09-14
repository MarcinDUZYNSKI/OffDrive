package pl.pojechali.offdrive.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setEmail("admin@admin.pl");
        user.setPassword("admin");
        user.setFirstName("Zbigniew");
        user.setLastName("Testowy");
        userService.saveUser(user);
        return "admin";
    }

}
