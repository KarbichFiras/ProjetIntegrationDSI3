package chmin9lewis.Restaurants.feane.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Metier.ICommandeMetier;
import chmin9lewis.Restaurants.feane.Model.OrderModel;
import reactor.core.publisher.Mono;

@RestController
public class CommandeService {

	@Autowired
	ICommandeMetier commandeMetier;
	
	@RequestMapping(value="/addCommande" ,  method = RequestMethod.POST)
	public Mono<OrderModel> addCommande(@RequestBody OrderModel order){
		
		return Mono.just(commandeMetier.addCommande(order));
		
	}
	
}
