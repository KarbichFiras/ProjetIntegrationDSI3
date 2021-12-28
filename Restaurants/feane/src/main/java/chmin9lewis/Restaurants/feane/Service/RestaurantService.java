package chmin9lewis.Restaurants.feane.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.Restaurant;
import chmin9lewis.Restaurants.feane.Metier.IRestaurantMetier;
import chmin9lewis.Restaurants.feane.Repository.RestaurantRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RestaurantService {
	@Autowired
	IRestaurantMetier restaurantMetier;

	
	@RequestMapping(value="/getAllRestaurants" , method = RequestMethod.GET)
	public List<Restaurant> getAllRestaurants() {
		return restaurantMetier.getAllRestaurants();
	}
	
	@RequestMapping(value="/getRestaurantDetails/{code}" , method = RequestMethod.GET)
	public Restaurant getRestaurantDetails(@PathVariable(name="code") Long restaurantCode) {
		return restaurantMetier.getRestaurantDetails(restaurantCode);
	}
	
	////////////////////////use it search bar
	@RequestMapping(value="/getSpecificRestaurant", method=RequestMethod.GET)
	public List<Restaurant> getSpecificRestaurant(@RequestParam(name="partLibelleR") String partLibelleRestaurant){
		return restaurantMetier.getSpecificRestaurant(partLibelleRestaurant);
	}
	
	/*WORKING BUT ITS FOR TESTING 
	 * @RequestMapping(value="/getRestaurantByFood", method=RequestMethod.GET)
	public Collection<Restaurant> getRestaurantByFood(@RequestParam(name="code") Long code){
		return restaurantMetier.getRestaurantByFood(code);
	}*/
	//
	@RequestMapping(value="/addRestaurant" , method = RequestMethod.POST)
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantMetier.addRestaurant(restaurant);
	}

	@RequestMapping(value="/updateRestaurant" , method = RequestMethod.PUT)
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantMetier.updateRestaurant(restaurant);
	}
	
	@RequestMapping(value="/deleteRestaurant" , method = RequestMethod.DELETE)
	public boolean deleteRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantMetier.deleteRestaurant(restaurant);
	}

	@RequestMapping(value="/deleteRestaurantById/{code}" , method = RequestMethod.DELETE)
	public boolean deleteRestaurantById(@PathVariable(name="code") Long  restaurantCode) {
		return restaurantMetier.deleteRestaurantById(restaurantCode);
	}

	@RequestMapping(value="/enableRestaurant/{code}" , method = RequestMethod.PUT)
	public boolean enableRestaurant(@PathVariable(name="code") Long restaurantCode) {
		return restaurantMetier.enableRestaurant(restaurantCode);
	}

	@RequestMapping(value="/desableRestaurant/{code}" , method = RequestMethod.PUT)
	public boolean desableRestaurant(@PathVariable(name="code") Long restaurantCode) {
		return restaurantMetier.desableRestaurant(restaurantCode);
	}
	
}
