package chmin9lewis.Restaurants.feane.Metier;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import chmin9lewis.Restaurants.feane.Entity.Commande;
import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.LigneCommande;
import chmin9lewis.Restaurants.feane.Entity.LigneCommandeExtras;
import chmin9lewis.Restaurants.feane.Entity.Restaurant;
import chmin9lewis.Restaurants.feane.Entity.Extras;
import chmin9lewis.Restaurants.feane.Model.ExtrasModel;
import chmin9lewis.Restaurants.feane.Model.OrderModel;
import chmin9lewis.Restaurants.feane.Model.Product;
import chmin9lewis.Restaurants.feane.Repository.CommandeRepository;
import chmin9lewis.Restaurants.feane.Repository.ExtrasRepository;
import chmin9lewis.Restaurants.feane.Repository.FoodRepository;
import chmin9lewis.Restaurants.feane.Repository.FoodWithExtrasRepository;
import chmin9lewis.Restaurants.feane.Repository.LigneCommandeExtrasRepository;
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
	
	@Autowired
	LigneCommandeExtrasRepository ligneCommandeExtrasRepository; 
	
	@Autowired
	FoodWithExtrasRepository foodWithExtrasRepository;
	
	@Autowired
	IRestaurantMetier restaurantMetier;
	
	@Autowired
	WebClient webClient;
	
	private static final String PRODUCT_CODE_SEPARATOR = ".";
	
	@Override
	public OrderModel addCommande(OrderModel order) {
		
		// TODO
		// we need to do some logic here so Restaurant have choice weather to accept or decline the commande
		
		
		boolean validRestaurantName = true;
		
		Collection<Product> products =  new ArrayList<Product>();
		
		double extrasPrix = 0;
		double foodPrix = 0;
		double T=0;//Totalle
		
		try {
			products = order.getProducts();
			for(Product p : products) {
				
				// a3mil test 3la ism lRestaurant ili bch yjik mil barra blkchi yatl3 we7id blid ba3ethlk ism min rassou same shit tintabe9 3al be99ii but manech fi production so ...
				if( restaurantMetier.getRestaurantByName(p.getRestaurantName()) == null ) {
					throw new RuntimeException("No restaurant with this name");
				}
				p.setRestaurantName(p.getRestaurantName());
				
				for(ExtrasModel e : p.getFoodWithExtras().getExtras()) {
						Extras extra = extrasRepository.findByName(e.getName().toUpperCase());
						e.setPrixUnitaire(extra.getPrixUnitaire());
						extrasPrix += e.getPrixUnitaire() * e.getQuantiteExtras();
					}
					
					Food f =foodRepository.findByLibelle(p.getFoodWithExtras().getFood().getLibelle().toUpperCase());
					
					p.getFoodWithExtras().getFood().setPrix(f.getPrix());
						foodPrix = p.getFoodWithExtras().getFood().getPrix() * p.getQuantiteFoodWithExtras() + extrasPrix;
						p.setPrixFinale(foodPrix);
					p.getFoodWithExtras().getFood().setCategorie(f.getCategorie().getName());
					p.getFoodWithExtras().getFood().setImage(f.getImage());
					p.getFoodWithExtras().setCode( foodWithExtrasRepository.findTopByFood(f).getCode() );
					
					// le code du prouit est la concatination du restaurantName et food name separer par une "."
					p.setCode( p.getRestaurantName() + PRODUCT_CODE_SEPARATOR + p.getFoodWithExtras().getFood().getLibelle() );
					
					T += p.getPrixFinale();
				}
			
			order.setProducts(products);
			order.setTotale(T);
			
			Commande c = new Commande();
				c.setClientUsername(order.getClientUsername());
				//c.setRestaurantName(order.());
				c.setTotale(T);
				c = commandeRepository.save(c);
					LigneCommande ligneCommande;
					Food f;
					LigneCommandeExtras ligneCommandeExtras;
					Extras extras;
					
					for(Product p : order.getProducts()) {
						f = foodRepository.findByLibelle(p.getFoodWithExtras().getFood().getLibelle());
							
							ligneCommande = new LigneCommande();
							ligneCommande.setFood(f);
							ligneCommande.setCommande(c);
							ligneCommande = ligneCommandeRepository.save(ligneCommande);
							
						for(ExtrasModel e : p.getFoodWithExtras().getExtras()) {
							
							ligneCommandeExtras = new LigneCommandeExtras();
									
							extras = new Extras();
							extras = extrasRepository.findByName(e.getName());
							extras.setQuantite(e.getQuantiteExtras());
							
							ligneCommandeExtras.setExtras(extras);
							ligneCommandeExtras.setLigneCommande(ligneCommande);
									
							extras.getLigneCommandeExtras().add(ligneCommandeExtras);
							extras = extrasRepository.save(extras);
									
							ligneCommande.getLigne_commande_extras().add(ligneCommandeExtras);
							ligneCommande = ligneCommandeRepository.save(ligneCommande);
							
						}
								
					}
			
			order.setRestaurantCommandeCode(c.getCode());
				
			return order;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
		
}
