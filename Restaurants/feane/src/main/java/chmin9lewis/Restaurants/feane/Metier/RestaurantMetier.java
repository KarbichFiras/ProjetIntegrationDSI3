package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Restaurant;
import chmin9lewis.Restaurants.feane.Entity.Role;
import chmin9lewis.Restaurants.feane.Entity.User;
import chmin9lewis.Restaurants.feane.Repository.RestaurantRepository;
import chmin9lewis.Restaurants.feane.Repository.RoleRepository;

@Service
public class RestaurantMetier implements IRestaurantMetier{

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	IUserMetier userMetier;
	
	@Override
	public Restaurant getRestaurantDetails(Long restaurantCode) {
		try {
			return restaurantRepository.findById(restaurantCode).get();
		}catch(Exception e) {
			System.out.println("Could not find any restaurant with this id : " + restaurantCode);
			return null;
		}
	}
	
	@Override
	public List<Restaurant> getEnabledRestaurants() {
		try {
			return restaurantRepository.findByIsEnabled(true);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Restaurant> getDesaabledRestaurants() {
		try {
			return restaurantRepository.findByIsEnabled(false);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		try {
			Role adminRole = roleRepository.findByName("ADMIN");
			User user = userMetier.getLoggedUser();

			// itha kenou admin nraj3oulou kol chay sinn nraj3ou ken les restau ili ye5dmou (active ya3ni mahomch msakrni yetsal7ou mathalan)
			if( user.getRoles().contains(adminRole)  ){
				return restaurantRepository.findAll();
			}
			
			return  getEnabledRestaurants();
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}
	
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public boolean deleteRestaurant(Restaurant restaurant) {
		try {
			restaurantRepository.delete(restaurant);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean deleteRestaurantById(Long restaurantCode) {
		try {
			restaurantRepository.deleteById(restaurantCode);
			return true;
		}catch(Exception e) {
			System.out.println("Could not delete restaurant with this id : " + restaurantCode);
			return false;
		}	
	}

	@Override
	public boolean enableRestaurant(Long restaurantCode) {
		try {
			Restaurant rest = restaurantRepository.findById(restaurantCode).get();
			rest.setEnabled(true);
			updateRestaurant(rest);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any restaurant with this id : " + restaurantCode);
			return false;
		}
	}

	@Override
	public boolean desableRestaurant(Long restaurantCode) {
		try {
			Restaurant rest = restaurantRepository.findById(restaurantCode).get();
			rest.setEnabled(false);
			updateRestaurant(rest);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any restaurant with this id : " + restaurantCode);
			return false;
		}
	}


}
