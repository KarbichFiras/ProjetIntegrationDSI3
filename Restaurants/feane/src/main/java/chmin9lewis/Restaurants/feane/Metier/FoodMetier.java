package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Repository.FoodRepository;

@Service
public class FoodMetier implements IFoodMetier{

	@Autowired
	FoodRepository foodRepository;

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
	
	
	
}
