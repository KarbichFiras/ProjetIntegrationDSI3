package chmin9lewis.Restaurants.feane.Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
	
	@GetMapping("/")
	public String home() {
		return "LandingPage/index";
	}
}
