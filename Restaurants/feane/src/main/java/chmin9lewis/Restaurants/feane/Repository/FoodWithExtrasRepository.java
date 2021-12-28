package chmin9lewis.Restaurants.feane.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;

public interface FoodWithExtrasRepository extends JpaRepository<FoodWithExtras, Long>{
	
}
