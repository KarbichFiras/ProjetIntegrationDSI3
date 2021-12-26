package chmin9lewis.Restaurants.feane.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chmin9lewis.Restaurants.feane.Entity.Extras;

public interface ExtrasRepository extends JpaRepository<Extras, Long>{

	public Extras findByName(String name);
	
}
