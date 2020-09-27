package pl.pojechali.offdrive.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class TripController {
    private final TripServiceImp tripService;

    @RequestMapping(value = {"/index/trip"}, method = RequestMethod.GET)
    public String createTrip(Model model){
        model.addAttribute("tripWithTripCondition", new TripWithTripCondition());
        return "trip/trip";
    }
    @RequestMapping(value = {"/index/trip"}, method = RequestMethod.POST)
    public String saveTrip(@Valid TripWithTripCondition tripWithTripCondition, BindingResult result){
        if (result.hasErrors()){
            return "trip/trip";
        }
        tripService.saveTrip(tripWithTripCondition.getTrip());
        tripService.saveTripCondition(tripWithTripCondition.getTripCondition());
        return "redirect:/index";
    }
    @RequestMapping("/trip/user_trips")
    public String findAllUserTrips(Model model){
        model.addAttribute("allUserTrips", tripService.findUserTripList());
        return "trip/user_trips";
    }

}
