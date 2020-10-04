package pl.pojechali.offdrive.route;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String findRouteByName(@RequestParam String routeName, Model model){
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
    public String showFindRoute(Model model){
        return "route/findRoute";
    }

    @RequestMapping(value = {"/index/routes"}, method = RequestMethod.GET, params = "userName")
    public String findRouteByUserName(@RequestParam(name = "userName") long id, Model model){
        model.addAttribute("routeList", routeService.findRouteListByUserId(id));
        return "route/findRoute";
    }

/*
    @RequestMapping(value = {"/index/editTrip/{id}"}, method = RequestMethod.GET)
    public String editTrip(@PathVariable long id, Model model){
        Trip trip = tripService.findTripById(id);
        if (trip == null){
            return "admin/403";
        }
//        TripWithTripCondition tripWithTripCondition = new TripWithTripCondition();
//        tripWithTripCondition.setTrip(trip);
//        tripWithTripCondition.setTripCondition(tripService.findTripConditionByTripId(id));
        model.addAttribute("trip", tripService.findTripById(id));
        return "trip/trip";

    }
    @RequestMapping(value = {"/index/editTrip/{id}"}, method = RequestMethod.POST)
    public String saveEditTrip(@Valid Trip trip, BindingResult result, long id){
        if (id != trip.getId()){
            return "admin/403";
        }
        if (result.hasErrors()){
            return "trip/trip";
        }
        //load trip
        //zmienic to co user user moze zmienic
        // ew zwalidować zmiany
        tripService.updateTrip(trip);
        return "redirect:/index";

    }

    @RequestMapping(value = {"/index/deleteTrip/{id}"}, method = RequestMethod.GET)
    public String deleteTrip(@PathVariable long id, Model model){
        Trip trip = tripService.findTripById(id);
        if (trip == null){
            return "admin/403";
        }
        model.addAttribute("trip", tripService.findTripById(id));
        return "trip/deleteConfirm";

    }
    @RequestMapping(value = {"/index/deleteTripConfirm/{id}"}, method = RequestMethod.GET)
    public String deleteTripConfirm(@PathVariable long id){
        Trip trip = tripService.findTripById(id);
        if (trip == null){
            return "admin/403";
        }
        tripService.deleteTripForUser(trip);
        return "redirect:/index";

    }

*/

}
