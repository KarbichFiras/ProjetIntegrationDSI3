package chmin9lewis.Restaurants.feane.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long>{

	@Query(nativeQuery = true ,value = "SELECT f.* FROM food f INNER JOIN ligne_commande lc "
			+ " where f.code=lc.food_code AND lc.code= :code")
	public List<Food> findFoodByUser(Long code);
}
