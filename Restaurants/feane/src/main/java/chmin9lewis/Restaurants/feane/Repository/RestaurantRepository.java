package chmin9lewis.Restaurants.feane.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import chmin9lewis.Restaurants.feane.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	public Restaurant findByName(String name);

	public List<Restaurant> findByIsEnabled(boolean isEnabled);
	 
	@Query( value="SELECT * FROM restaurant  WHERE enabled=:isEnabled" , nativeQuery = true)
	public Page<Restaurant> getEnabledRestaurants(boolean isEnabled, Pageable paging);
	
	@Query( value="SELECT * FROM restaurant  WHERE enabled=:isEnabled" , nativeQuery = true)
	public Page<Restaurant> getDesabledRestaurants(boolean isEnabled, Pageable paging);
	
	public Page<Restaurant> findAll(Pageable pageable);
	
}
