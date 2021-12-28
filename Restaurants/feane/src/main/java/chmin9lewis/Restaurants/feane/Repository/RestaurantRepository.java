package chmin9lewis.Restaurants.feane.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import chmin9lewis.Restaurants.feane.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	public Restaurant findByName(String name);

	public List<Restaurant> findByIsEnabled(boolean isEnabled);
	
}
