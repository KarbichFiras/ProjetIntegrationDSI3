package chmin9lewis.Restaurants.feane.Metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Null;

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
	public List<Restaurant> getRestaurantBySpecificFood(String partLibelle) {
		 List<Food> Results_of_food_get  ;
		// Collection<Restaurant> Results_of_restaurants_get = null  ;
		 List<Restaurant> Results_of_restaurants_get = new ArrayList<>();
		try {
			 Results_of_food_get=foodRepository.findBylibelleLikeIgnoreCase("%"+partLibelle+"%");
				
			 for (int i = 0; i < Results_of_food_get.size(); i++) {
		 		Long code=Results_of_food_get.get(i).getCode();
		 		Results_of_restaurants_get.addAll(restaurantRepository.findRestaurantByFood(code));
				    
				}
			 
			 return Results_of_restaurants_get;
		}catch(Exception e) {
			System.out.println("Could not find any food with this pasing carateters  " + partLibelle);
			return null;
		}
		
	}


	
	
	
}
