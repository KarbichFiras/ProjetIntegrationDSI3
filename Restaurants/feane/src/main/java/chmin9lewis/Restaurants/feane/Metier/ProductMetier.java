package chmin9lewis.Restaurants.feane.Metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Extras;
import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Model.ExtrasModel;
import chmin9lewis.Restaurants.feane.Model.Product;
import chmin9lewis.Restaurants.feane.Repository.ExtrasRepository;
import chmin9lewis.Restaurants.feane.Repository.FoodRepository;
import chmin9lewis.Restaurants.feane.Repository.FoodWithExtrasRepository;

@Service
public class ProductMetier implements IProductMetier{

	@Autowired
	ExtrasRepository extrasRepository;
	
	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	FoodWithExtrasRepository foodWithExtrasRepository;
	
	private static final String PRODUCT_CODE_SEPARATOR = ".";
	
	@Override
	public Product calculPrix(Product p) {
		
		double extrasPrix = 0;
		double foodPrix = 0;
		double T=0;//Totalle
		
		for(ExtrasModel e : p.getFoodWithExtras().getExtras()) {
			Extras extra = extrasRepository.findByName(e.getName().toUpperCase());
			e.setPrixUnitaire(extra.getPrixUnitaire());
			extrasPrix += e.getPrixUnitaire() * e.getQuantiteExtras();
		}
		
		Food f =foodRepository.findByLibelle(p.getFoodWithExtras().getFood().getLibelle().toUpperCase());
		if(p.getQuantiteFoodWithExtras() == 0) {p.setQuantiteFoodWithExtras(1);}
		p.getFoodWithExtras().getFood().setPrix(f.getPrix());
			foodPrix = p.getFoodWithExtras().getFood().getPrix() * p.getQuantiteFoodWithExtras() + extrasPrix;
			p.setPrixFinale(foodPrix);
			
		p.getFoodWithExtras().getFood().setCategorie(f.getCategorie().getName());
		p.getFoodWithExtras().getFood().setImage(f.getImage());
		p.getFoodWithExtras().setCode( foodWithExtrasRepository.findTopByFood(f).getCode() );
		
		// le code du prouit est la concatination du restaurantName et food name separer par une "."
		p.setCode( p.getRestaurantName() + PRODUCT_CODE_SEPARATOR + p.getFoodWithExtras().getFood().getLibelle() );
		
		
		
		return p;
	
	}

}
