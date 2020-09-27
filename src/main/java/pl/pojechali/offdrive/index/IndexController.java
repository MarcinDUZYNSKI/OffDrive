package pl.pojechali.offdrive.index;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pojechali.offdrive.route.RouteServiceImpl;
import pl.pojechali.offdrive.trip.TripServiceImp;

import java.util.DuplicateFormatFlagsException;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final TripServiceImp tripService;
    private final RouteServiceImpl routeService;

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String showIndex(Model model) {
//      return "index";
//  }
//  @RequestMapping(value = {"/index/user_trips"}, method = RequestMethod.GET)
//  public String findAllUserTrips(Model model){



//        model.addAttribute("allUserTrips", tripService.findUserTripList()); // prawdopodobnie do przeniesienia do trip
        return "index";
    }

    @RequestMapping(value = {"/index/createRoute/{id}"})
    public String saveRoute(@PathVariable long id) { // trzeba dorobić zabezpieczenie żeby nie można było stworzyć ponownie Route z już stworzonego Tripa
//        if (tripService.getTripRepository().findById(id) == null) {  // tu jest zły warunek do weryfikacji możliwego błędu
//            return "error";
//        }
        try {
        routeService.saveRouteFromTrip(tripService.findTripById(id));
    }catch (DuplicateFormatFlagsException dffe){
            dffe.printStackTrace();
            return "redirect:/home";
        }
//        return "/index/index";  // czemu po zawołaniu górnego adresu return nie przenosi dalej tylko adres w przeglądarce zostaje z żądania?? Oraz wyświetla się bez GET-a
        return "redirect:/index";

    }

}
