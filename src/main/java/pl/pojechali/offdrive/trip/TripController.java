package pl.pojechali.offdrive.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class TripController {
    private final TripServiceImp tripService;

    @RequestMapping(value = {"/index/trip"}, method = RequestMethod.GET)
    public String createTrip(Model model){
        model.addAttribute("trip", new Trip());
        return "trip/trip";

    }

    @RequestMapping(value = {"/index/trip"}, method = RequestMethod.POST)
    public String saveTrip(@Valid Trip trip, BindingResult result){
        if (result.hasErrors()){
            return "trip/trip";
        }  // podpiąć się pod errory w springu zeby ąłdnie obsłużyć -> java.lang.NumberFormatException
        trip.getTripCondition().setTrip(trip);
        tripService.saveTrip(trip);
        return "redirect:/index";

    }
    @RequestMapping("/index/user_trips")
    public String findAllUserTrips(Model model){
        model.addAttribute("allUserTrips", tripService.findUserTripList());
        return "trip/user_trips";
    }

    @RequestMapping(value = "/index/createTrip/{id}", method = RequestMethod.GET)
    public String saveTripFomRoute(@PathVariable long id) {
        tripService.saveTripFromRoute(id);
        return "redirect:/index/user_trips";
    }

    @RequestMapping(value = {"/index/editTrip/{id}"}, method = RequestMethod.GET)
    public String editTrip(@PathVariable long id, Model model){
        Trip trip = tripService.findTripById(id);
        if (trip == null){
            return "admin/403";
        }
//        TripWithTripCondition tripWithTripCondition = new TripWithTripCondition();
//        tripWithTripCondition.setTrip(trip);
//        tripWithTripCondition.setTripCondition(tripService.findTripConditionByTripId(id));
        model.addAttribute("trip", trip);
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
        model.addAttribute("trip", trip);
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


//    @RequestMapping(value = {"/index/editTrip/{trip.id}/{tripCondition.id}"}, method = RequestMethod.POST) // nie działa method Post not suported
//    public String saveEditTrip(@Valid TripWithTripCondition tripWithTripCondition, BindingResult result, long tripId, long tripConditionId){
//        if (tripId != tripWithTripCondition.getTrip().getId() || tripConditionId != tripWithTripCondition.getTripCondition().getId()){
//            return "admin/403";
//        }
//        if (result.hasErrors()){
//            return "trip/trip";
//        }
//        tripService.updateTrip(tripWithTripCondition.getTrip());
//        tripService.saveTripCondition(tripWithTripCondition.getTripCondition());
//        return "redirect:/index";
//
//    }

}
