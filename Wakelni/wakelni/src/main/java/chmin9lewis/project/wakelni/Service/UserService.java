package chmin9lewis.project.wakelni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import chmin9lewis.project.wakelni.Entity.Client;
import chmin9lewis.project.wakelni.Entity.Commande;
import chmin9lewis.project.wakelni.Entity.DeliveryMan;
import chmin9lewis.project.wakelni.Entity.Employe;
import chmin9lewis.project.wakelni.Entity.Facture;
import chmin9lewis.project.wakelni.Entity.Role;
import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Metier.ICommandeMetier;
import chmin9lewis.project.wakelni.Metier.IFactureMetier;
import chmin9lewis.project.wakelni.Metier.IRoleMetier;
import chmin9lewis.project.wakelni.Metier.IUserMetier;
import chmin9lewis.project.wakelni.Models.Order;
import chmin9lewis.project.wakelni.Models.Restaurant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class UserService {
	@Autowired
	IUserMetier userMetier;
	@Autowired
	IRoleMetier roleMetier;
	
	@Autowired
	IFactureMetier factureMetier;
	
	@Autowired
	ICommandeMetier commandeMetier;
	
	@Autowired
	WebClient webClient;
	
	// lezmik t3adilou token fil header 5ater walina jwt ma3adech session ;p
	@RequestMapping(value="/getLoggedInUser" , method = RequestMethod.GET)
	public User testUser() {
		return userMetier.getLoggedUser();
	}
	
	@RequestMapping(value="/addClient" , method = RequestMethod.POST)
	public User addClient(@RequestBody Client client) {
		try {
			return userMetier.addUser(client);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/addEmploye" , method = RequestMethod.POST)
	public User addEmploye(@RequestBody Employe employe) {
		try {
			return userMetier.addUser(employe);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/addDeliveryMan" , method = RequestMethod.POST)
	public User addDeleveryMan(@RequestBody DeliveryMan deliveryMan) {
		try {
			return userMetier.addUser(deliveryMan);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/addRole", method = RequestMethod.POST)
	public Role addRole(@RequestBody Role role) {
		try {
			return roleMetier.addRole(role);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//get facture consult facture
	@RequestMapping(value="/consultFacture",method = RequestMethod.GET)
	public Facture consultFacture(@RequestParam(name="code") Long u) {
		try {
			return factureMetier.findById(u);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
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
			
			o.setExternalClientUsername(userMetier.getLoggedUser().getUserName());
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
