package chmin9lewis.project.wakelni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import chmin9lewis.project.wakelni.Models.Register;
import chmin9lewis.project.wakelni.Models.Restaurant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin
public class AppService {
	@Autowired
	IUserMetier userMetier;
	@Autowired
	IRoleMetier roleMetier;
	
	@Autowired
	IFactureMetier factureMetier;
	
	@Autowired
	ICommandeMetier commandeMetier;
	
	
	
	// lezmik t3adilou token fil header 5ater walina jwt ma3adech session ;p
	@RequestMapping(value="/getLoggedInUser" , method = RequestMethod.GET)
	public User testUser() {
		return userMetier.getLoggedUser();
	}
	
	@RequestMapping(value="/addClient" , method = RequestMethod.POST)
	public User addClient(@RequestBody Register client) {
		try {
			return userMetier.addUser(client);
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


}
