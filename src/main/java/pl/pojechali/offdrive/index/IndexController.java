package pl.pojechali.offdrive.index;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pojechali.offdrive.exception.RouteAlreadyExistException;
import pl.pojechali.offdrive.route.RouteServiceImpl;
import pl.pojechali.offdrive.trip.TripServiceImp;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final TripServiceImp tripService;
    private final RouteServiceImpl routeService;

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String showIndex(Model model) {
        return "index";
    }

    @RequestMapping(value = {"/index/createRoute/{id}"})
    public String saveRoute(@PathVariable long id) { // trzeba dorobić zabezpieczenie żeby nie można było stworzyć ponownie Route z już stworzonego Tripa
//        if (tripService.getTripRepository().findById(id) == null) {  // tu jest zły warunek do weryfikacji możliwego błędu
//            return "error";
//        }  // to przenieść do servisów żęby walidacja była przprowadzana na poziomie servisu dla pużniejszego resta
        try {
            routeService.saveRouteFromTripWithUpdateTrip(tripService.findTripById(id));
        } catch (RouteAlreadyExistException dffe) {
            dffe.printStackTrace();
            return "redirect:/403"; // do poprawienie przekierowanie przy zapisie już istniejącego route
        }
        return "redirect:/index";

    }

}
