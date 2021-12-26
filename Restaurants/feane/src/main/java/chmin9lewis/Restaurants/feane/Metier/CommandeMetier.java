package chmin9lewis.Restaurants.feane.Metier;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Model.Extras;
import chmin9lewis.Restaurants.feane.Model.Order;
import chmin9lewis.Restaurants.feane.Model.Plat;
import chmin9lewis.Restaurants.feane.Repository.CommandeRepository;
import chmin9lewis.Restaurants.feane.Repository.ExtrasRepository;
import chmin9lewis.Restaurants.feane.Repository.FoodRepository;
import reactor.core.publisher.Mono;

@Service
public class CommandeMetier implements ICommandeMetier{

	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	FoodRepository foodRepository; 
	
	@Autowired
	ExtrasRepository extrasRepository; 
	
	@Override
	public Order addCommande(Order order) {
		
		Collection<Plat> plats =  new ArrayList<Plat>();
		double T=0;//Totalle
		try {
			plats = order.getPlats();
			for(Plat p : plats) {
				for(Extras e : p.getExtras()) {
					chmin9lewis.Restaurants.feane.Entity.Extras extra = extrasRepository.findByName(e.getName().toUpperCase());
					e.setPrixUnitaire(extra.getPrixUnitaire());
					T += e.getPrixUnitaire() * e.getQuantiteExtras();
				}
				p.getFood().setPrix(foodRepository.findByLibelle(p.getFood().getLibelle().toUpperCase()).getPrix());
				p.getFood().setCategorie(foodRepository.findByLibelle(p.getFood().getLibelle().toUpperCase()).getCategorie().getName());
				p.getFood().setImage(foodRepository.findByLibelle(p.getFood().getLibelle().toUpperCase()).getImage());
				T += p.getFood().getPrix() * p.getQuantiteFood();
			}
			
			order.setPlats(plats);
			order.setTotale(T);
			
			return order;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
