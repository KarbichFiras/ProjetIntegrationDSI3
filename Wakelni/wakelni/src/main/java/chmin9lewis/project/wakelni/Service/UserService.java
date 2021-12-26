package chmin9lewis.project.wakelni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

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
	
	@RequestMapping(value="/addUser" , method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		return userMetier.addUser(user);
	}
	
	@RequestMapping(value="/addRole", method = RequestMethod.POST)
	public Role addRole(@RequestBody Role role) {
		return roleMetier.addRole(role);
	}
	
	//get facture consult facture
	@RequestMapping(value="/consultFacture",method = RequestMethod.GET)
	public Facture consultFacture(@RequestParam(name="code") Long u) {
		return factureRepository.findById(u).get();
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
