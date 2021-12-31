package chmin9lewis.Restaurants.feane.Service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;
import chmin9lewis.Restaurants.feane.Metier.IFoodMetier;
import chmin9lewis.Restaurants.feane.Metier.IFoodWithExtrasMetier;
import chmin9lewis.Restaurants.feane.Model.ExtrasModel;
import chmin9lewis.Restaurants.feane.Model.FoodModel;
import chmin9lewis.Restaurants.feane.Model.Product;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ApiService {

	@Autowired
	IFoodMetier foodMetier;
	
	@Autowired
	IFoodWithExtrasMetier foodWithExtrasMetier;
	
	// method qui return un product a partir du nom "libelle" d'un food 
	@RequestMapping(value="/getProduct",method=RequestMethod.GET)
	public Product getProduct(@RequestParam(name="libelle") String libelle){
		Product product = new Product();
		FoodModel foodModel ;
		ExtrasModel extrasModel;
		
		Food food = foodMetier.getFoodByLibelle(libelle);
		Collection<FoodWithExtras> res= new ArrayList<FoodWithExtras>();
		res =  foodWithExtrasMetier.getFoodWithExtrasByFood(food);

		
		int i = 0; // variable bch ntasti bih samitou hkk
		for(FoodWithExtras f : res) {
			if(i==0) {
				// on create un instance du FoodModel a partir du food
				foodModel = new FoodModel(f.getFood());
				product.setFood(foodModel);
			}
			
			extrasModel = new ExtrasModel(f.getExtras());
			
			product.getExtras().add(extrasModel);
		}
		
		return product;
	}
	
}
