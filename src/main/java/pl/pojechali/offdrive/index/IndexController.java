package pl.pojechali.offdrive.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
@GetMapping("index/index")
  public String showIndexPage() {
  return "index/index";
}
}
