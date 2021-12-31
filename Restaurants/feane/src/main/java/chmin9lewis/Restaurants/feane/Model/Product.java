package chmin9lewis.Restaurants.feane.Model;

import java.util.ArrayList;
import java.util.Collection;

public class Product {

	private String code;
	private FoodModel food;
	private Collection<ExtrasModel> extras =  new ArrayList<ExtrasModel>();
	private int quantiteFood;
	private double prixFinale;
	private String restaurantName;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public FoodModel getFood() {
		return food;
	}

	public void setFood(FoodModel food) {
		this.food = food;
	}

	public Collection<ExtrasModel> getExtras() {
		return extras;
	}

	public void setExtras(Collection<ExtrasModel> extras) {
		this.extras = extras;
	}

	public int getQuantiteFood() {
		return quantiteFood;
	}

	public void setQuantiteFood(int quantiteFood) {
		this.quantiteFood = quantiteFood;
	}

	public double getPrixFinale() {
		return prixFinale;
	}

	public void setPrixFinale(double prixFinale) {
		this.prixFinale = prixFinale;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	
	
}
