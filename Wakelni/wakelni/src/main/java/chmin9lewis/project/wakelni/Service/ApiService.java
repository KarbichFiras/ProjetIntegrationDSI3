package chmin9lewis.project.wakelni.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


import chmin9lewis.project.wakelni.Entity.Commande;
import chmin9lewis.project.wakelni.Entity.Facture;
import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Metier.ICommandeMetier;
import chmin9lewis.project.wakelni.Metier.IFactureMetier;
import chmin9lewis.project.wakelni.Metier.IUserMetier;
import chmin9lewis.project.wakelni.Models.Food;
import chmin9lewis.project.wakelni.Models.FoodExtrasCategorieModel;
import chmin9lewis.project.wakelni.Models.FoodWithExtras;
import chmin9lewis.project.wakelni.Models.Order;
import chmin9lewis.project.wakelni.Models.Product;
import chmin9lewis.project.wakelni.Models.Android.RestaurantAndroidModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/api/restaurants")
public class ApiService {

	@Autowired
	IUserMetier userMetier;
	
	@Autowired
	IFactureMetier factureMetier;
	
	@Autowired
	ICommandeMetier commandeMetier;
	
	@Autowired
	WebClient webClient;

	
	@RequestMapping(value="/getProduct", method=RequestMethod.GET)
	public Mono<Product> getProduct(@RequestParam(name="libelle") String libelle) {
		return webClient.get()
				.uri("/product/getProduct?libelle="+libelle)
				.header("Authorization", ApisKeys.MY_FEANE_KEY)
				.retrieve()
				.bodyToMono(Product.class);
	
	}
	
	
//add getAllFoods for consuming
	@RequestMapping(value="/getAllFoods", method=RequestMethod.GET)
	public Flux<Food> getAllFoods() {
		return webClient.get()
				.uri("/getAllFoods")
				.header("Authorization", ApisKeys.MY_FEANE_KEY)
				.retrieve()
				.bodyToFlux(Food.class);
	}
	
	
	
	
	
	
	@RequestMapping(value="/getFooddeatildByRestaurant", method=RequestMethod.GET)
	public Flux<FoodExtrasCategorieModel> getFooddeatildByRestaurant(@RequestParam(name="code") Long code) {
		return webClient.get()
				.uri("/getFooddeatildByRestaurant?code="+code)
				.header("Authorization", ApisKeys.MY_FEANE_KEY)
				.retrieve()
				.bodyToFlux(FoodExtrasCategorieModel.class);
	
	}
	
	//search restaurant by any caracter in food libelle
	@RequestMapping(value="/getRestaurantByFood", method = RequestMethod.GET)
	public Flux<RestaurantAndroidModel> getRestaurantByFood(@RequestParam(name="partLibelleFood") String partLibelleFood){
		
		return 	webClient.get()
				.uri("/RestaurantFoodService/getRestaurantByFood?partLibelleFood="+partLibelleFood)
				.header("Authorization", ApisKeys.MY_FEANE_KEY)
				.retrieve()
				.bodyToFlux(RestaurantAndroidModel.class);
		
	}
	
	//search restaurant by any caracter in restaurant name
		@RequestMapping(value="/getSpecificRestaurant", method = RequestMethod.GET)
		public Flux<RestaurantAndroidModel> getSpecificRestaurant(@RequestParam(name="partnameResto") String partnameResto){
			
			
			
			return 	webClient.get()
					.uri("/restaurants/getSpecificRestaurant?partnameResto="+partnameResto)
					.header("Authorization", ApisKeys.MY_FEANE_KEY)
					.retrieve()
					.bodyToFlux(RestaurantAndroidModel.class);
			
		}
	//cart
		//one food with extra
		@RequestMapping(value="/getFoodWithExtrasDetails", method = RequestMethod.GET)
		public Flux<FoodWithExtras> getFoodWithExtrasDetails(@RequestParam(name="code") Long foodWithExtrasCode){
			
			return 	webClient.get()
					.uri("/getFoodWithExtrasDetails/"+foodWithExtrasCode)
					.header("Authorization", ApisKeys.MY_FEANE_KEY)
					.retrieve()
					.bodyToFlux(FoodWithExtras.class);
			
		}
		
	
		
		
	@RequestMapping(value="/getAllRestaurants", method = RequestMethod.GET)
	public Flux<RestaurantAndroidModel> getAllRestaurants(){
		
		return 	webClient.get()
				.uri("/restaurants/getAllRestaurants")
				.header("Authorization", ApisKeys.MY_FEANE_KEY)
				.retrieve()
				.bodyToFlux(RestaurantAndroidModel.class);
		
	}
	
	@RequestMapping(value="/getRestaurantByCode/{code}", method = RequestMethod.GET)
	public Mono<RestaurantAndroidModel> getRestaurantByCode(@PathVariable(name="code") Long code){
		return 	webClient.get()
				.uri("/restaurants/getRestaurantByCode/"+code)
				.header("Authorization", ApisKeys.MY_FEANE_KEY)
				.retrieve()
				.bodyToMono(RestaurantAndroidModel.class);
		
	}
	
	@RequestMapping(value="/getProductsByRestaurantName",method=RequestMethod.GET)
	public Flux<Product> getProductsByRestaurantName(@RequestParam(name="restaurantName") String restaurantName){
		
		return webClient.get()
				.uri("/product/getProductsByRestaurantName?restaurantName="+restaurantName)
				.header("Authorization", ApisKeys.MY_FEANE_KEY)
				.retrieve()
				.bodyToFlux(Product.class);
	}
	
	@RequestMapping(value="/newOrder", method = RequestMethod.POST)
	public Order newOrder(@RequestBody Order o){
		User client;
		try {
			
			o.setClientUsername(userMetier.getLoggedUser().getUsername());
			
			Order order = 	webClient.post()
					.uri("/addCommande")
					.header("Authorization", ApisKeys.MY_FEANE_KEY)
					.body(Mono.just(o), Order.class)
					.retrieve()
					.bodyToMono(Order.class)
					.block();//bch yo93ed yestaneh 7atta yjewbou wba3ed ykamil yexecuti ili ta7tou :/
			
			Facture f= new Facture();
				f.setModePaiment("Online");
				f.setTotal(order.getTotale());
				f.setRestaurantCommandeCode(order.getRestaurantCommandeCode());
			f = factureMetier.addFacture(f);
			
			Commande c = new Commande();
				c.setAdresseLivraison("Bizerte : mil front tit5ith linfo hethi");
					client =  userMetier.getLoggedUser();	
				c.setClient(client);
				c.setFacture(f);
			c = commandeMetier.addCommande(c);
			userMetier.updateUser(client);
				
			return order;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
