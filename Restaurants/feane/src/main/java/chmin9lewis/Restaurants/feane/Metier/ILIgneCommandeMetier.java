package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.Food;

public interface ILIgneCommandeMetier {
	public List<Food> getFoodsByUser(Long code);
}
