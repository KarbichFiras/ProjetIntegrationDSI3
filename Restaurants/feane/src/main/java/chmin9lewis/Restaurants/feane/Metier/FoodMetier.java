package chmin9lewis.Restaurants.feane.Metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.Restaurant;
import chmin9lewis.Restaurants.feane.Repository.FoodRepository;
import chmin9lewis.Restaurants.feane.Repository.RestaurantRepository;

@Service
public class FoodMetier implements IFoodMetier{

	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	@Override
	public Food getFoodDetails(Long foodCode) {
		try {
			return foodRepository.findById(foodCode).get();
		}catch(Exception e) {
			System.out.println("Could not find any food with this id : " + foodCode);
			return null;
		}
	}

	@Override
	public List<Food> getAllFoods() {
		try {
			return foodRepository.findAll();
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Food addFood(Food food) {
		try {
			return foodRepository.save(food);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Food updateFood(Food food) {
		try {
			return foodRepository.save(food);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public boolean deleteFood(Food food) {
		try {
			foodRepository.delete(food);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean deleteFoodById(Long foodCode) {
		try {
			foodRepository.deleteById(foodCode);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean enableFood(Long foodCode) {
		try {
			Food food = foodRepository.findById(foodCode).get();
			food.setEnabled(true);
			updateFood(food);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any food with this id : " + foodCode);
			return false;
		}
	}

	@Override
	public boolean desableFood(Long foodCode) {
		try {
			Food food = foodRepository.findById(foodCode).get();
			food.setEnabled(false);
			updateFood(food);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any food with this id : " + foodCode);
			return false;
		}
	}

	@Override
	public Food getFoodByLibelle(String libelle) {
		try {
		return foodRepository.findByLibelle(libelle);
		}catch(Exception e) {
			System.out.println("Could not find any food with this libelle : " + libelle);
			return null;
		}
	}

	@Override
	public List<Food> getSpecificFood(String  partLibelleFood) {
		return 	this.foodRepository.findBylibelleLikeIgnoreCase("%"+partLibelleFood+"%");
		
	}

	
	@Override
	public List<Restaurant> getRestaurantByFood(String partLibelleFood) {
		
		try {
			List<Food> results_food;
			List<Restaurant> results_restaurant_from_food = new ArrayList<>();
		
			results_food=this.foodRepository.findBylibelleLikeIgnoreCase("%"+partLibelleFood+"%");
			
			for( int i = 0;i<results_food.size();i++) {
				
				Long code =results_food.get(i).getCode();
				results_restaurant_from_food.addAll(this.restaurantRepository.findRestaurantByFood(code))  ;
				
			}
			
			
			return results_restaurant_from_food;
			}catch(Exception e) {
				System.out.println("Could not find result for search rstaurant using food  : " + e);
				return null;
			}	
	}
	@Override
	public List<Food> getFoodByPartName(String partLibelleFood) {
		
		try {
			
		
			return this.foodRepository.findBylibelleLikeIgnoreCase("%"+partLibelleFood+"%");

			}catch(Exception e) {
				System.out.println("Could not find resultfood   : " + e);
				return null;
			}	
	}
	
	
}
