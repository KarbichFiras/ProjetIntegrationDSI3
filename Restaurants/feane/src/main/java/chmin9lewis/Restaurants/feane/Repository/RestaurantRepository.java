package chmin9lewis.Restaurants.feane.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import chmin9lewis.Restaurants.feane.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	public Restaurant findByName(String restaurantName);

	public List<Restaurant> findByIsEnabled(boolean isEnabled);
	 
	@Query( value="SELECT * FROM restaurant  WHERE enabled=:isEnabled" , nativeQuery = true)
	public Page<Restaurant> getEnabledRestaurantsPage(boolean isEnabled, Pageable paging);
	
	@Query( value="SELECT * FROM restaurant  WHERE enabled=:isEnabled" , nativeQuery = true)
	public List<Restaurant> getEnabledRestaurants(boolean isEnabled);
	
	@Query( value="SELECT * FROM restaurant  WHERE enabled=:isEnabled" , nativeQuery = true)
	public Page<Restaurant> getDesabledRestaurantsPage(boolean isEnabled, Pageable paging);
	
	@Query( value="SELECT * FROM restaurant  WHERE enabled=:isEnabled" , nativeQuery = true)
	public List<Restaurant> getDesabledRestaurants(boolean isEnabled);
	
	public Page<Restaurant> findAll(Pageable pageable);
	
	public List<Restaurant> findByNameLikeIgnoreCase(String name);
	
	@Query(nativeQuery = true ,value = "SELECT r.* FROM food_with_extras fwe INNER JOIN Menu m INNER JOIN Restaurant r"
			+ " where fwe.menu_code = m.code AND m.restaurant_code =r.code AND fwe.code= :code")
	public Collection<Restaurant> findRestaurantByFood(Long code);

}
