package chmin9lewis.Restaurants.feane.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;
import chmin9lewis.Restaurants.feane.Model.FoodExtrasCategorieModel;
import chmin9lewis.Restaurants.feane.Repository.FoodWithExtrasRepository;

@RestController
@CrossOrigin
public class FoodExtrasCategorieService {

	@Autowired
	FoodWithExtrasRepository foodWithExtrasRepository;
	
	
	@RequestMapping(value="/getFooddeatildByRestaurant", method=RequestMethod.GET)
	public Collection<FoodExtrasCategorieModel> getFooddeatildByRestaurant(@RequestParam(name="code") Long code) {
		return foodWithExtrasRepository.findFooddeatildByRestaurant(code);
	}
}
