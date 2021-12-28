package chmin9lewis.Restaurants.feane.Service;

import java.util.ArrayList;
import java.util.Collection;
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
public class FoodRestaurantService {
	@Autowired
	IFoodMetier foodMetier;
	////////////////////////////////use in search in wakalni app
	@RequestMapping(value="/getRestaurantBySpecificFood", method=RequestMethod.GET)
	public  List<Restaurant>  getRestaurantBySpecificFood(@RequestParam(name="partLibelleF") String partLibelleFood){
	return foodMetier.getRestaurantBySpecificFood(partLibelleFood);
	}
	
}
