package chmin9lewis.Restaurants.feane.Repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;
import chmin9lewis.Restaurants.feane.Entity.Menu;
import chmin9lewis.Restaurants.feane.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	public Restaurant findByName(String name);

	public List<Restaurant> findByNameLikeIgnoreCase(String name);
	
			
	@Query(nativeQuery = true ,value = "SELECT r.* from food_with_extras fwe INNER JOIN menu m INNER JOIN restaurant r where fwe.menu_code = m.code AND m.restaurant_code =r.code AND fwe.food_code= :code")
	public Collection<Restaurant> findRestaurantByFood(Long code);

}
