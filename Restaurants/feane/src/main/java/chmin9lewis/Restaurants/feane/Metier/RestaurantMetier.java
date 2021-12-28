package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
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
	public Page<Restaurant> getEnabledRestaurants(Integer page, Integer size,String sortBy, String direction) {
		try {
			
			Pageable paging;
			
			if(direction.toUpperCase().equals("ASC")) {
				 paging =PageRequest.of(page, size, Sort.by(sortBy).ascending());
			}else {
				 paging =PageRequest.of(page, size, Sort.by(sortBy).descending());
			}
			
			Page<Restaurant> pageResult = restaurantRepository.getEnabledRestaurants(true, paging);
			
			return pageResult;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public Page<Restaurant> getDesaabledRestaurants( Integer page, Integer size,String sortBy, String direction) {
		try {
			Pageable paging;
			
			if(direction.toUpperCase().equals("ASC")) {
				 paging =PageRequest.of(page, size, Sort.by(sortBy).ascending());
			}else {
				 paging =PageRequest.of(page, size, Sort.by(sortBy).descending());
			}
			
			Page<Restaurant> pageResult = restaurantRepository.getDesabledRestaurants(false, paging);
			
			return pageResult;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Page<Restaurant> getAllRestaurants(Integer page, Integer size,String sortBy, String direction) {
		try {
			
			Role adminRole = roleRepository.findByName("ADMIN");
			try {
				
				User user = userMetier.getLoggedUser();
				
				// itha kenou admin nraj3oulou kol chay sinn nraj3ou ken les restau ili ye5dmou (active ya3ni mahomch msakrni yetsal7ou mathalan)
				if( user.getRoles().contains(adminRole)  ){
					Pageable paging;
					
					if(direction.toUpperCase().equals("ASC")) {
						 paging =PageRequest.of(page, size, Sort.by(sortBy).ascending());
					}else {
						 paging =PageRequest.of(page, size, Sort.by(sortBy).descending());
					}
					return restaurantRepository.findAll(paging);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return getEnabledRestaurants(page, size, sortBy, direction) ;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}
	
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		try {
			return restaurantRepository.save(restaurant);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		try {
			return restaurantRepository.save(restaurant);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
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
