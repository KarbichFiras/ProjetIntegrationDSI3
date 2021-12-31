package chmin9lewis.Restaurants.feane.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;
import chmin9lewis.Restaurants.feane.Model.FoodExtrasCategorieModel;
import chmin9lewis.Restaurants.feane.Entity.Food;

public interface FoodWithExtrasRepository extends JpaRepository<FoodWithExtras, Long>{
	

	@Query(nativeQuery = true ,value ="SELECT  r.name as namer,f.libelle,f.prix,f.image,c.name as  namec,e.name as nameex,e.quantite,e.prix_unitaire   "
			+ "FROM restaurant r , menu m , categorie c,food_with_extras fwe ,food f,extras e where r.code=m.restaurant_code "
			+ "AND  m.code =fwe.menu_code AND fwe.food_code=f.code AND  f.categorie_code=c.code AND e.code=fwe.extras_code AND r.code= :code")
	public Collection<FoodExtrasCategorieModel> findFooddeatildByRestaurant(Long code);
	
	public Collection<FoodWithExtras> findByFood(Food food);
	
}
