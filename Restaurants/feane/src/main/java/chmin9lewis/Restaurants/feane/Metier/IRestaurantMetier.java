package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.data.domain.Page;

import chmin9lewis.Restaurants.feane.Entity.Restaurant;

public interface IRestaurantMetier {

	public Restaurant getRestaurantDetails(Long restaurantCode);
	public List<Restaurant> getAllRestaurants();
	public Page<Restaurant> getAllRestaurantsPage(Integer page, Integer size, String sortBy, String direction);
	public List<Restaurant> getEnabledRestaurants();
	public Page<Restaurant> getEnabledRestaurantsPage( Integer page, Integer size,String sortBy, String direction);
	public List<Restaurant> getDesabledRestaurants();
	public Page<Restaurant> getDesabledRestaurantsPage( Integer page, Integer size,String sortBy, String direction);
	public Restaurant addRestaurant(Restaurant restaurant);
	public Restaurant updateRestaurant(Restaurant restaurant);
	public boolean deleteRestaurant(Restaurant restaurant);
	public boolean deleteRestaurantById(Long restaurantCode);
	public boolean enableRestaurant(Long restaurantCode);
	public boolean desableRestaurant(Long restaurantCode);
}
