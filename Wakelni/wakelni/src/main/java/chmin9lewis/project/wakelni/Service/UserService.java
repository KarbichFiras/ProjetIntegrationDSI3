package chmin9lewis.project.wakelni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import chmin9lewis.project.wakelni.Entity.Role;
import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Metier.IRoleMetier;
import chmin9lewis.project.wakelni.Metier.IUserMetier;
import chmin9lewis.project.wakelni.Models.Restaurant;
import reactor.core.publisher.Flux;


@RestController
public class UserService {
	@Autowired
	IUserMetier userMetier;
	@Autowired
	IRoleMetier roleMetier;
	
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
	
	@RequestMapping(value="/getAllRestaurants", method = RequestMethod.GET)
	public Flux<Restaurant> getAllRestaurants(){
		
		return 	webClient.get()
				.uri("/getAllRestaurants")
				.retrieve()
				.bodyToFlux(Restaurant.class);
	}
	
	
}
