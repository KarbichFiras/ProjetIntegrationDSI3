package chmin9lewis.project.wakelni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import chmin9lewis.project.wakelni.Entity.Client;
import chmin9lewis.project.wakelni.Entity.DeliveryMan;
import chmin9lewis.project.wakelni.Entity.Employe;
import chmin9lewis.project.wakelni.Entity.Facture;
import chmin9lewis.project.wakelni.Entity.Role;
import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Metier.IRoleMetier;
import chmin9lewis.project.wakelni.Metier.IUserMetier;
import chmin9lewis.project.wakelni.Models.Restaurant;
import chmin9lewis.project.wakelni.Repository.FactureRepository;
import reactor.core.publisher.Flux;


@RestController
public class UserService {
	@Autowired
	IUserMetier userMetier;
	@Autowired
	IRoleMetier roleMetier;
	@Autowired 
	FactureRepository factureRepository;
	
	@Autowired
	WebClient webClient;
	
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
			return factureRepository.findById(u).get();
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
	
	
}
