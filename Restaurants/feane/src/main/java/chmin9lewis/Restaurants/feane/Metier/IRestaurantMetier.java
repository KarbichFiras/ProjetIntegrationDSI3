package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.Restaurant;

public interface IRestaurantMetier {

	public Restaurant getRestaurantDetails(Long restaurantCode);
	public List<Restaurant> getAllRestaurants();
	public List<Restaurant> getEnabledRestaurants();
	public List<Restaurant> getDesaabledRestaurants();
	public Restaurant addRestaurant(Restaurant restaurant);
	public Restaurant updateRestaurant(Restaurant restaurant);
	public boolean deleteRestaurant(Restaurant restaurant);
	public boolean deleteRestaurantById(Long restaurantCode);
	public boolean enableRestaurant(Long restaurantCode);
	public boolean desableRestaurant(Long restaurantCode);
	
}
