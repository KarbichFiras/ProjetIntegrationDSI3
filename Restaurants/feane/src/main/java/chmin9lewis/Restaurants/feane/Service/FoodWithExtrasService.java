package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;
import chmin9lewis.Restaurants.feane.Metier.IFoodWithExtrasMetier;

@RestController
@CrossOrigin
public class FoodWithExtrasService {

	@Autowired
	IFoodWithExtrasMetier foodmExtrasMetier;
	
	@RequestMapping(value="/getFoodWithExtrasDetails/{code}", method=RequestMethod.GET)
	public FoodWithExtras getFoodWithExtrasDetails(@PathVariable(name="code") Long foodWithExtrasCode) {
		return foodmExtrasMetier.getFoodWithExtrasDetails(foodWithExtrasCode);
	}

	@RequestMapping(value="/getAllFoodWithExtras", method=RequestMethod.GET)
	public List<FoodWithExtras> getAllFoodWithExtras() {
		return foodmExtrasMetier.getAllFoodWithExtras();
	}
	
	@RequestMapping(value="/addFoodWithExtras", method=RequestMethod.POST)
	public FoodWithExtras addFoodWithExtras(@RequestBody FoodWithExtras foodWithExtras) {
		return foodmExtrasMetier.addFoodWithExtras(foodWithExtras);
	}

	@RequestMapping(value="/updateFoodWithExtras", method=RequestMethod.PUT)
	public FoodWithExtras updateFoodWithExtras(@RequestBody FoodWithExtras foodWithExtras) {
		return foodmExtrasMetier.updateFoodWithExtras(foodWithExtras);
	}

	@RequestMapping(value="/deleteFoodWithExtras", method=RequestMethod.DELETE)
	public boolean deleteFoodWithExtras(@RequestBody FoodWithExtras foodWithExtras) {
		return foodmExtrasMetier.deleteFoodWithExtras(foodWithExtras);
	}

	@RequestMapping(value="/deleteFoodWithExtrasById/{code}", method=RequestMethod.DELETE)
	public boolean deleteFoodWithExtrasById(@PathVariable(name="code") Long foodWithExtrasCode) {
		return foodmExtrasMetier.deleteFoodWithExtrasById(foodWithExtrasCode);
	}

	@RequestMapping(value="/enableFoodWithExtras/{code}", method=RequestMethod.PUT)
	public boolean enableFoodWithExtras(@PathVariable(name="code") Long foodWithExtrasCode) {
		return foodmExtrasMetier.enableFoodWithExtras(foodWithExtrasCode);
	}

	@RequestMapping(value="/desableFoodWithExtras/{code}", method=RequestMethod.PUT)
	public boolean desableFoodWithExtras(@PathVariable(name="code") Long foodWithExtrasCode) {
		return foodmExtrasMetier.desableFoodWithExtras(foodWithExtrasCode);
	}
	
}
