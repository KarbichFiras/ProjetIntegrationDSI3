package chmin9lewis.Restaurants.feane.Metier;

import java.util.Collection;
import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;



public interface IFoodWithExtrasMetier {
	
	public Collection<FoodWithExtras> getFoodWithExtrasByFood(Food food);
	public FoodWithExtras getFoodWithExtrasDetails(Long foodWithExtrasCode);
	public List<FoodWithExtras> getAllFoodWithExtras();
	public FoodWithExtras addFoodWithExtras(FoodWithExtras foodWithExtras);
	public FoodWithExtras updateFoodWithExtras(FoodWithExtras foodWithExtras);
	public boolean deleteFoodWithExtras(FoodWithExtras foodWithExtras);
	public boolean deleteFoodWithExtrasById(Long foodWithExtrasCode);
	public boolean enableFoodWithExtras(Long foodWithExtrasCode);
	public boolean desableFoodWithExtras(Long foodWithExtrasCode);
	
}
