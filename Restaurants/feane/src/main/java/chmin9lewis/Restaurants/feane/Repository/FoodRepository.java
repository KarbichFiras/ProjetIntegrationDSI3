package chmin9lewis.Restaurants.feane.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chmin9lewis.Restaurants.feane.Entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

	public Food findByLibelle(String libelle);
	
}
