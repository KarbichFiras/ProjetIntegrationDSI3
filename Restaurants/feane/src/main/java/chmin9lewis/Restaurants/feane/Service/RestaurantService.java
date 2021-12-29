package chmin9lewis.Restaurants.feane.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

@CrossOrigin
@RestController
@RequestMapping("restaurants")
public class RestaurantService {
	@Autowired
	IRestaurantMetier restaurantMetier;
	
	@RequestMapping(value="/getAllRestaurants" , method = RequestMethod.GET)
	public List<Restaurant> getAllRestaurants() {
		return restaurantMetier.getAllRestaurants();
	}
	
	@RequestMapping(value="/getSpecificRestaurant", method=RequestMethod.GET)
	public List<Restaurant> getSpecificRestaurant(@RequestParam(name="partnameResto") String partnameResto) {
		return restaurantMetier.getSpecificRestaurant(partnameResto);
	}
	
	@RequestMapping(value="/getEnabledRestaurants" , method = RequestMethod.GET)
	public List<Restaurant> getEnabledRestaurants() {
		return restaurantMetier.getEnabledRestaurants();
	}

	@RequestMapping(value="/getDesabledRestaurants" , method = RequestMethod.GET)
	public List<Restaurant> getDesabledRestaurants() {
		return restaurantMetier.getDesabledRestaurants();
	}
	
	@RequestMapping(value="/getAllRestaurantsPage" , method = RequestMethod.GET)
	public Page<Restaurant> getAllRestaurantsPage(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction) {
		return restaurantMetier.getAllRestaurantsPage(page.orElse(0), size.orElse(5), sortBy.orElse("code"), direction.orElse("ASC"));
	}

	@RequestMapping(value="/getEnabledRestaurantsPage" , method = RequestMethod.GET)
	public Page<Restaurant> getEnabledRestaurantsPage(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction) {
		//size mil mosta7sen ta3mlou final wta3tih enti lvaleur , 5ater ynjm yjik we7id blid wy7otlk size 1 000 000 fodha m3a aka wa9tha yrazenlk serveur
		return restaurantMetier.getEnabledRestaurantsPage(page.orElse(0), size.orElse(5), sortBy.orElse("name"), direction.orElse("ASC"));
	}

	@RequestMapping(value="/getDesabledRestaurantsPage" , method = RequestMethod.GET)
	public Page<Restaurant> getDesabledRestaurantsPage(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction) {
		return restaurantMetier.getDesabledRestaurantsPage(page.orElse(0), size.orElse(5), sortBy.orElse("name"), direction.orElse("ASC"));
	}
	
	@RequestMapping(value="/getRestaurantByCode/{code}" , method = RequestMethod.GET)
	public Restaurant getRestaurantByCode(@PathVariable(name="code") Long restaurantCode) {
		return restaurantMetier.getRestaurantDetails(restaurantCode);
	}
	
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
