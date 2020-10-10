package pl.pojechali.offdrive.trip;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor @Slf4j
public class TripController {
    private final TripServiceImp tripService;

    @RequestMapping(value = {"/index/trip"}, method = RequestMethod.GET)
    public String createTrip(Model model) {
        model.addAttribute("trip", new Trip());
        return "trip/trip";
    }

    @RequestMapping(value = {"/index/trip"}, method = RequestMethod.POST)
    public String saveTrip(@Valid Trip trip, BindingResult result) {
        log.info("trip: {}", trip);
        if (result.hasErrors()) {
            log.debug("errors: {}", result);
            return "trip/trip";
        }  // podpiąć się pod errory w springu zeby ąłdnie obsłużyć -> java.lang.NumberFormatException
        trip.getTripCondition().setTrip(trip);
        tripService.saveTrip(trip);
        return "redirect:/index";
    }

    @RequestMapping("/index/user_trips")
    public String findAllUserTrips(Model model) {
        model.addAttribute("allUserTrips", tripService.findUserTripList());
        return "trip/user_trips";
    }

    @RequestMapping(value = "/index/createTrip/{id}", method = RequestMethod.GET)
    public String saveTripFomRoute(@PathVariable long id) {
        tripService.saveTripFromRoute(id);
        return "redirect:/index/user_trips";
    }

    @RequestMapping(value = {"/index/editTrip/{id}"}, method = RequestMethod.GET)
    public String editTrip(@PathVariable long id, Model model) {
        Trip trip = tripService.findTripById(id);
        if (trip == null) {
            return "admin/403";
        }
        if (tripService.getCurrentLoginUser().getId() != trip.getUser().getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        model.addAttribute("trip", trip);
        return "trip/trip";
    }

    @RequestMapping(value = {"/index/editTrip/{id}"}, method = RequestMethod.POST)
    public String saveEditTrip(@Valid Trip trip, BindingResult result, long id) {
        if (id != trip.getId()) {
            return "admin/403";
        }
        if (tripService.getCurrentLoginUser().getId() != tripService.findTripById(trip.getId()).getUser().getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        if (result.hasErrors()) {
            return "trip/trip";
        }
        tripService.updateTrip(trip);
        return "redirect:/index";
    }

    @RequestMapping(value = {"/index/deleteTrip/{id}"}, method = RequestMethod.GET)
    public String deleteTrip(@PathVariable long id, Model model) {
        Trip trip = tripService.findTripById(id);
        if (trip == null) {
            return "admin/403";
        }
        if (tripService.getCurrentLoginUser().getId() != trip.getUser().getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        model.addAttribute("trip", trip);
        return "trip/deleteConfirm";
    }

    @RequestMapping(value = {"/index/deleteTripConfirm/{id}"}, method = RequestMethod.GET)
    public String deleteTripConfirm(@PathVariable long id) {
        Trip trip = tripService.findTripById(id);
        if (trip == null) {
            return "admin/403";
        }
        if (tripService.getCurrentLoginUser().getId() != tripService.findTripById(trip.getId()).getUser().getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        tripService.deleteTripForUser(trip);
        return "redirect:/index";
    }

}
