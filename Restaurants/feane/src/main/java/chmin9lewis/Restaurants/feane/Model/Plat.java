package chmin9lewis.Restaurants.feane.Model;

import java.util.Collection;

public class Plat{

	private Collection<Extras> extras;
	private Food food;
	private int quantiteFood = 1;//quantite ta3 lfood ili y7eb 3leha lclient 
	
	public Plat() {
		super();
	}
	
	public Collection<Extras> getExtras() {
		return extras;
	}

	public void setExtras(Collection<Extras> extras) {
		this.extras = extras;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getQuantiteFood() {
		return quantiteFood;
	}

	public void setQuantiteFood(int quantiteFood) {
		this.quantiteFood = quantiteFood;
	}
}
