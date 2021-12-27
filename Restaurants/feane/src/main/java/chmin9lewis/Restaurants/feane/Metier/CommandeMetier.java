package chmin9lewis.Restaurants.feane.Metier;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Commande;
import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.LigneCommande;
import chmin9lewis.Restaurants.feane.Entity.Extras;
import chmin9lewis.Restaurants.feane.Model.ExtrasModel;
import chmin9lewis.Restaurants.feane.Model.OrderModel;
import chmin9lewis.Restaurants.feane.Model.PlatModel;
import chmin9lewis.Restaurants.feane.Repository.CommandeRepository;
import chmin9lewis.Restaurants.feane.Repository.ExtrasRepository;
import chmin9lewis.Restaurants.feane.Repository.FoodRepository;
import chmin9lewis.Restaurants.feane.Repository.LigneCommandeRepository;

@Service
public class CommandeMetier implements ICommandeMetier{

	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired	
	FoodRepository foodRepository; 
	
	@Autowired
	ExtrasRepository extrasRepository; 
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	
	@AutoConfigureOrder
	FoodRepository FoodRepository;
	
	@Override
	public OrderModel addCommande(OrderModel order) {
		
		Collection<PlatModel> plats =  new ArrayList<PlatModel>();
		double T=0;//Totalle
		try {
			plats = order.getPlats();
			for(PlatModel p : plats) {
				for(ExtrasModel e : p.getExtras()) {
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
			
			Commande c = new Commande();
				c.setClientUsername(order.getExternalClientUsername());
				c.setRestaurantName(order.getRestaurantName());
				c.setTotale(T);
				c = commandeRepository.save(c);
					LigneCommande ligneCommande;
					Food f;
					
					for(PlatModel p : order.getPlats()) {
						f = foodRepository.findByLibelle(p.getFood().getLibelle());
							
							ligneCommande = new LigneCommande();
							ligneCommande.setFood(f);
							ligneCommande.setCommande(c);
							ligneCommande = ligneCommandeRepository.save(ligneCommande);
					}

			return order;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
