package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Restaurant;
import chmin9lewis.Restaurants.feane.Metier.IFoodMetier;

@RestController
@CrossOrigin
public class RestaurantFoodService {

	@Autowired
	IFoodMetier foodMetier;
	
	
	@RequestMapping(value="/getRestaurantByFood", method=RequestMethod.GET)
	public List<Restaurant> getRestaurantByFood(@RequestParam(name="partLibelleFood") String partLibelleFood) {
		return foodMetier.getRestaurantByFood(partLibelleFood);
	}
}
