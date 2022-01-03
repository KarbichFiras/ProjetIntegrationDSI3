package chmin9lewis.Restaurants.feane.Service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import chmin9lewis.Restaurants.feane.Entity.Extras;
import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;
import chmin9lewis.Restaurants.feane.Entity.Menu;
import chmin9lewis.Restaurants.feane.Entity.Restaurant;
import chmin9lewis.Restaurants.feane.Metier.IFoodMetier;
import chmin9lewis.Restaurants.feane.Metier.IFoodWithExtrasMetier;
import chmin9lewis.Restaurants.feane.Metier.IMenuMetier;
import chmin9lewis.Restaurants.feane.Metier.IProductMetier;
import chmin9lewis.Restaurants.feane.Metier.IRestaurantMetier;
import chmin9lewis.Restaurants.feane.Model.ExtrasModel;
import chmin9lewis.Restaurants.feane.Model.FoodModel;
import chmin9lewis.Restaurants.feane.Model.FoodWithExtrasModel;
import chmin9lewis.Restaurants.feane.Model.Product;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ApiService {

	@Autowired
	IFoodMetier foodMetier;
	
	@Autowired
	IFoodWithExtrasMetier foodWithExtrasMetier;
	
	@Autowired
	IRestaurantMetier restaurantMetier;
	
	@Autowired
	IMenuMetier menuMetier;
	
	@Autowired
	WebClient webClient;
	
	@Autowired
	IProductMetier productMetier;
	
	private static final String PRODUCT_CODE_SEPARATOR = ".";
	
	// method qui return un product a partir du nom "libelle" d'un food 
	@RequestMapping(value="/getProduct",method=RequestMethod.GET)
	public Product getProduct(@RequestParam(name="libelle") String libelle){
		Product product = new Product();
		FoodModel foodModel ;
		ExtrasModel extrasModel;
		FoodWithExtrasModel foodWithExtrasModel = new FoodWithExtrasModel();; 
		
		Food food = foodMetier.getFoodByLibelle(libelle);
		Collection<FoodWithExtras> res= new ArrayList<FoodWithExtras>();
		res =  foodWithExtrasMetier.getFoodWithExtrasByFood(food);

		
		int i = 0; // variable bch ntasti bih samitou hkk
		for(FoodWithExtras f : res) {
			if(i==0) {
				// on create un instance du FoodModel a partir du food
					foodModel = new FoodModel(f.getFood());
				foodWithExtrasModel.setFood(foodModel);
				
				foodWithExtrasModel.setCode(f.getCode());
				i=1;// bl3anni bch y3abi lfood marra bark ( perfermonce :p )
			}
			
			extrasModel = new ExtrasModel(f.getExtras());
			
			foodWithExtrasModel.getExtras().add(extrasModel);
		}
		
		Restaurant restaurant = webClient.get()
						.uri("/product/getRestaurantByFoodWithExtrasCode?code="+foodWithExtrasModel.getCode())
						.retrieve()
						.bodyToMono(Restaurant.class)
						.block();
		
		product.setRestaurantName(restaurant.getName());
		product.setFoodWithExtras(foodWithExtrasModel);
		product.setCode(restaurant.getName()+ PRODUCT_CODE_SEPARATOR + libelle);
		
		return product;
	}
	
	@RequestMapping(value="/getRestaurantByFoodWithExtrasCode",method=RequestMethod.GET)
	public Restaurant getRestaurantByFoodWithExtrasCode(@RequestParam(name="code") Long code){
		
		FoodWithExtras foodWithExtras = foodWithExtrasMetier.getFoodWithExtrasDetails(code);
		
		// code 3omrou mehou bch ykoun null ==> 5ater every single foodWithExtras marbout bMenu kbir fil DB nsamiweh catalogue .
		Menu menu = menuMetier.getMenuDetails(foodWithExtras.getMenu().getCode());
		
		return menu.getRestaurant();
	}
	
	
	@RequestMapping(value="/getProductsByRestaurantName",method=RequestMethod.GET)
	public Collection<Product> getProductsByRestaurantName(@RequestParam(name="restaurantName") String restaurantName){
		Product product ;
		
		Restaurant restaurant = restaurantMetier.getRestaurantByName(restaurantName);
		
		Collection<Menu> menus = restaurant.getMenus();
		Collection<Product> products = new ArrayList<Product>();
		
		for ( Menu m : menus) {
			for(FoodWithExtras fe : m.getMenuFoods()) {
				
				product = new Product();
				
				product = webClient.get()
						.uri("/product/getProduct?libelle="+fe.getFood().getLibelle())
						.retrieve()
						.bodyToMono(Product.class)
						.block();
				
 
				productMetier.calculPrix(product);
				
				products.add(product);
				
			}
		}
		
		return products;
	}
	
}
































