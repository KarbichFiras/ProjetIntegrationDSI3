package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.Restaurant;

public interface IFoodMetier {

	public Food getFoodDetails(Long foodCode);
	public Food getFoodByLibelle(String libelle);
	public List<Food> getAllFoods();
	public List<Restaurant> getRestaurantByFood(String partLibelleFood);
	public List<Food> getFoodByPartName(String partLibelleFood);
	public Food addFood(Food food);
	public Food updateFood(Food food);
	public boolean deleteFood(Food food);
	public boolean deleteFoodById(Long foodCode);
	public boolean enableFood(Long foodCode);
	public boolean desableFood(Long foodCode);
	public List<Food> getSpecificFood(String partLibelleFood);
	
}
