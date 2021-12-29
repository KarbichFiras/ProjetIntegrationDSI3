package chmin9lewis.project.wakelni.Service;

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
import chmin9lewis.project.wakelni.Models.FoodWithExtras;
import chmin9lewis.project.wakelni.Models.Order;
import chmin9lewis.project.wakelni.Models.Restaurant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class ApiService {

	@Autowired
	IUserMetier userMetier;
	
	@Autowired
	IFactureMetier factureMetier;
	
	@Autowired
	ICommandeMetier commandeMetier;
	@Autowired
	WebClient webClient;
	
	//search restaurant by any caracter in food libelle
	@RequestMapping(value="/getRestaurantByFood", method = RequestMethod.GET)
	public Flux<Restaurant> getRestaurantByFood(@RequestParam(name="partLibelleFood") String partLibelleFood){
		
		return 	webClient.get()
				.uri("/getRestaurantByFood?partLibelleFood="+partLibelleFood)
				.header("Authorization", TokensProperties.MY_TOKEN)
				.retrieve()
				.bodyToFlux(Restaurant.class);
		
	}
	
	//search restaurant by any caracter in restaurant name
		@RequestMapping(value="/getSpecificRestaurant", method = RequestMethod.GET)
		public Flux<Restaurant> getSpecificRestaurant(@RequestParam(name="partnameResto") String partnameResto){
			
			return 	webClient.get()
					.uri("/getSpecificRestaurant?partnameResto="+partnameResto)
					.header("Authorization", TokensProperties.MY_TOKEN)
					.retrieve()
					.bodyToFlux(Restaurant.class);
			
		}
	//cart
		//one food with extra
		@RequestMapping(value="/getFoodWithExtrasDetails", method = RequestMethod.GET)
		public Flux<FoodWithExtras> getFoodWithExtrasDetails(@RequestParam(name="code") Long foodWithExtrasCode){
			
			return 	webClient.get()
					.uri("/getFoodWithExtrasDetails/{code}")
					.header("Authorization", TokensProperties.MY_TOKEN)
					.retrieve()
					.bodyToFlux(FoodWithExtras.class);
			
		}
		
	
	@RequestMapping(value="/getAllRestaurants", method = RequestMethod.GET)
	public Flux<Restaurant> getAllRestaurants(){
		
		return 	webClient.get()
				.uri("/getAllRestaurants")
				.header("Authorization", TokensProperties.MY_TOKEN)
				.retrieve()
				.bodyToFlux(Restaurant.class);
		
	}
	
	@RequestMapping(value="/newOrder", method = RequestMethod.POST)
	public Order newOrder(@RequestBody Order o){
		User client;
		try {
			
			o.setExternalClientUsername(userMetier.getLoggedUser().getUsername());
			o.setRestaurantName("Feane");
			
			Order order = 	webClient.post()
					.uri("/addCommande")
					.header("Authorization", TokensProperties.MY_TOKEN)
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
