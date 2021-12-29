package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Extras;
import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Metier.ILIgneCommandeMetier;
	

@RestController
public class CartService {
	@Autowired
	ILIgneCommandeMetier ligneCommandeMetier;
	
	@RequestMapping(value="/getFoodsByUser", method=RequestMethod.GET)
	public List<Food> getFoodsByUser(@RequestParam(name="code") Long code) {
		return ligneCommandeMetier.getFoodsByUser(code);
	}
}
