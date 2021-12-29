package chmin9lewis.Restaurants.feane.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import chmin9lewis.Restaurants.feane.Entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

	public Food findByLibelle(String libelle);
	public List<Food> findBylibelleLikeIgnoreCase(String libelle);
	
	
}
