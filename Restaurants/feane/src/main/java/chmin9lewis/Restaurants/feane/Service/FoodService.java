package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Metier.IFoodMetier;

@RestController
@CrossOrigin
public class FoodService {

	@Autowired
	IFoodMetier foodMetier;
	
	@RequestMapping(value="/getFoodDetails/{code}", method=RequestMethod.GET)
	public Food getFoodDetails(@PathVariable(name="code") Long foodCode) {
		return foodMetier.getFoodDetails(foodCode);
	}

	@RequestMapping(value="/getAllFoods", method=RequestMethod.GET)
	public List<Food> getAllFoods() {
		return foodMetier.getAllFoods();
	}
	
	@RequestMapping(value="/getSpecificFood", method=RequestMethod.GET)
	public List<Food> getSpecificFood(@RequestParam(name="partLibelleFood") String partLibelleFood) {
		return foodMetier.getSpecificFood(partLibelleFood);
	}
	
	@RequestMapping(value="/getFoodByPartName", method=RequestMethod.GET)
	public List<Food> getFoodByPartName(@RequestParam(name="partLibelleFood") String partLibelleFood) {
		return foodMetier.getFoodByPartName(partLibelleFood);
	}
	
	@RequestMapping(value="/addFood", method=RequestMethod.POST)
	public Food addFood(@RequestBody Food food) {
		return foodMetier.addFood(food);
	}

	@RequestMapping(value="/updateFood", method=RequestMethod.PUT)
	public Food updateFood(@RequestBody Food food) {
		return foodMetier.updateFood(food);
	}

	@RequestMapping(value="/deleteFood", method=RequestMethod.DELETE)
	public boolean deleteFood(@RequestBody Food food) {
		return foodMetier.deleteFood(food);
	}

	@RequestMapping(value="/deleteFoodById/{code}", method=RequestMethod.DELETE)
	public boolean deleteFoodById(@PathVariable(name="code") Long foodCode) {
		return foodMetier.deleteFoodById(foodCode);
	}

	@RequestMapping(value="/enableFood/{code}", method=RequestMethod.PUT)
	public boolean enableFood(@PathVariable(name="code") Long foodCode) {
		return foodMetier.enableFood(foodCode);
	}

	@RequestMapping(value="/desableFood/{code}", method=RequestMethod.PUT)
	public boolean desableFood(@PathVariable(name="code") Long foodCode) {
		return foodMetier.desableFood(foodCode);
	}

}
