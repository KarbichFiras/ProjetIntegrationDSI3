package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Repository.LigneCommandeRepository;

@Service
public class LigneCommandeMetier implements ILIgneCommandeMetier{
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;

	@Override
	public List<Food> getFoodsByUser(Long code) {
		
		return this.ligneCommandeRepository.findFoodByUser(code);
	}

}
