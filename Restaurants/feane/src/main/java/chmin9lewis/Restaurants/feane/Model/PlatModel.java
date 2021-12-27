package chmin9lewis.Restaurants.feane.Model;

import java.util.Collection;

public class PlatModel{

	private Collection<ExtrasModel> extras;
	private FoodModel food;
	private int quantiteFood = 1;//quantite ta3 lfood ili y7eb 3leha lclient 
	
	public PlatModel() {
		super();
	}
	
	public Collection<ExtrasModel> getExtras() {
		return extras;
	}

	public void setExtras(Collection<ExtrasModel> extras) {
		this.extras = extras;
	}

	public FoodModel getFood() {
		return food;
	}

	public void setFood(FoodModel food) {
		this.food = food;
	}

	public int getQuantiteFood() {
		return quantiteFood;
	}

	public void setQuantiteFood(int quantiteFood) {
		this.quantiteFood = quantiteFood;
	}
}
