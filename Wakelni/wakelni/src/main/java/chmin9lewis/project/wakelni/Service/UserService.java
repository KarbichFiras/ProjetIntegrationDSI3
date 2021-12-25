package chmin9lewis.project.wakelni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import chmin9lewis.project.wakelni.Entity.Client;
import chmin9lewis.project.wakelni.Entity.Role;
import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Metier.IClientMetier;
import chmin9lewis.project.wakelni.Metier.IRoleMetier;
import chmin9lewis.project.wakelni.Metier.IUserMetier;
import chmin9lewis.project.wakelni.Models.Restaurant;
import reactor.core.publisher.Flux;


@RestController
public class UserService {
	@Autowired
	IClientMetier clientMetier;
	@Autowired
	IRoleMetier roleMetier;
	
	@Autowired
	// AutoWiring with the bean at WakelniApplication.java
	private WebClient.Builder webClientBuilder;
	
	WebClient webClient;
	
	/*@RequestMapping(value="/addUser" , method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		return userMetier.addUser(user);
	}*/
	@RequestMapping(value="/addClient" , method = RequestMethod.POST)
	public User addClient(@RequestBody Client client) {
		return clientMetier.addClient(client);
	}
	
	@RequestMapping(value="/addRole", method = RequestMethod.POST)
	public Role addRole(@RequestBody Role role) {
		return roleMetier.addRole(role);
	}
	
	@RequestMapping(value="/getAllRestaurants", method = RequestMethod.GET)
	public Flux<Restaurant> getAllRestaurants(){
		
		webClient = webClientBuilder.build();
		
		return 	webClient.get()
				.uri("/getAllRestaurants")
				.retrieve()
				.bodyToFlux(Restaurant.class);
	}
	
	
}
