package chmin9lewis.Restaurants.feane.Repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;
import chmin9lewis.Restaurants.feane.Entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long>{


	//Menu findByMenuFoods(ArrayList<FoodWithExtras> foodWithExtras);

}
