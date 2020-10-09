package pl.pojechali.offdrive.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import pl.pojechali.offdrive.exception.UserAlreadyExistException;
import pl.pojechali.offdrive.trip.Trip;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @RequestMapping(value = {"/admin/createUser"}, method = RequestMethod.GET)
//    @GetMapping("/admin/createUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "admin/user_form";
    }

    @RequestMapping(value = "/admin/createUser", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "admin/user_form";
        }
        if(user.getPassword() == null) {
            return "admin/user_form";
        }
        try {
            userService.saveUser(user);
        } catch (UserAlreadyExistException e) {
            result.rejectValue("email", "user.email","An account already exists for this email.");
            return "admin/user_form";
        }
        return "admin/login";
    }

    @RequestMapping(value = {"/index/editUser"}, method = RequestMethod.GET)
    public String editUser(Model model){
        User user = userService.getCurrentLoginUser();
//                findUserById(id);
        if (user == null){
            return "admin/403";
        }
        model.addAttribute("user", user);
        return "admin/edit_user";

    }
    @RequestMapping(value = {"/index/editUser"}, method = RequestMethod.POST)
    public String saveEditUser(@Valid User user, BindingResult result) throws UserAlreadyExistException {
        if (result.hasErrors()){
            return "admin/edit_user";
        }
        userService.updateUser(user);
        return "redirect:/index";
    }

    @RequestMapping(value = "/index/deleteUser", method = RequestMethod.GET)
    public String removeUser(Model model) {
        User user = userService.getCurrentLoginUser();
        if (user == null) {
            return "admin/403";
        }
        model.addAttribute("user", userService.getCurrentLoginUser());
        return "admin/deleteConfirm";
    }
    @RequestMapping("/index/approvedUserDelete")
    public String deleteUser() {
        User user = userService.getCurrentLoginUser();
        if(user == null) {
            return "admin/403";
        }
        userService.deleteUser(user);
        return "redirect:/perform_logout";
    }

    @RequestMapping("/index/userProfile")
    public String showUserProfile(Model model) {
        model.addAttribute("currentUser", userService.getCurrentLoginUser());
        return "admin/user_profile";
    }

}
