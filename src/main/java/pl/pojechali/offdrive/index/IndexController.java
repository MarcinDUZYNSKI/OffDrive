package pl.pojechali.offdrive.index;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pojechali.offdrive.trip.TripServiceImp;

@Controller
@RequiredArgsConstructor
public class IndexController {
  private final TripServiceImp tripService;

  @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
  public String showIndex(Model model){
    return "index";
  }
}
