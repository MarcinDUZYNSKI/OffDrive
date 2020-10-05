package pl.pojechali.offdrive.route;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class RouteController {
    private final RouteServiceImpl routeService;

//    @RequestMapping(value = "/index/routes", method = RequestMethod.GET)
//    public String findAllUserRoads(Model model){
//        model.addAttribute("routeList", routeService.findUserRouteList());
//        return "route/findRoute";
//    }

    @RequestMapping(value = {"/index/routes"}, method = RequestMethod.GET, params = "routeName")
    public String findRouteByName(@RequestParam String routeName, Model model) {
        model.addAttribute("routeList", routeService.findRoutesByName(routeName));
        return "route/findRoute";
    }

    @ModelAttribute("userMap")
    public Map<Long, String> userMap() {
        return routeService.findAllIdNickNameMapWithRouts();
    }

    @ModelAttribute("currentUser")
    public Long currentLoginUserId() {
        return routeService.getCurrentLoginUserId();
    }

    @RequestMapping(value = "/index/routes", method = RequestMethod.GET) //model atribute
    public String showFindRoute(Model model) {
        return "route/findRoute";
    }

    @RequestMapping(value = {"/index/routes"}, method = RequestMethod.GET, params = "userName")
    public String findRouteByUserName(@RequestParam(name = "userName") long id, Model model) {
        model.addAttribute("routeList", routeService.findRouteListByUserId(id));
        return "route/findRoute";
    }

    @RequestMapping(value = "/index/createTrip/{id}", method = RequestMethod.GET)
    public String saveTripFomRoute(@PathVariable long id) {
        routeService.saveTripFromRoute(id);
        return "redirect:/index/user_trips";
    }

    @RequestMapping(value = {"/index/editRoute/{id}"}, method = RequestMethod.GET)
    public String editRoute(@PathVariable long id, Model model){
        Route route = routeService.findRouteById(id);
        if (route == null){
            return "admin/403";
        }
        model.addAttribute("route", route);
        return "route/editRoute";
    }

    @RequestMapping(value = {"/index/editRoute/{id}"}, method = RequestMethod.POST)
    public String saveEditTrip(@Valid Route route, BindingResult result, long id){
        if (id != route.getId()){
            return "admin/403";
        }
        if (result.hasErrors()){
            return "route/editRoute";
        }
        routeService.updateRoute(route);
        return "redirect:/index";
    }

    @RequestMapping(value = {"/index/deleteRoute/{id}"}, method = RequestMethod.GET)
    public String deleteRoute(@PathVariable long id, Model model){
        Route route = routeService.findRouteById(id);
        if (route == null){
            return "admin/403";
        }
        model.addAttribute("route", route);
        return "trip/deleteConfirm";
    }

    @RequestMapping(value = {"/index/deleteRouteConfirm/{id}"}, method = RequestMethod.GET)
    public String deleteRouteConfirm(@PathVariable long id){
        Route route = routeService.findRouteById(id);
        if (route == null){
            return "admin/403";
        }
        routeService.deleteRouteForUser(route);
        return "redirect:/index";

    }

}
