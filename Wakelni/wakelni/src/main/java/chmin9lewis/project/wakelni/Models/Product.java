package chmin9lewis.project.wakelni.Models;

import java.util.Collection;

public class Product {

	private String code;
	private Food food;
	private Collection<Extras> extras;
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
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Collection<Extras> getExtras() {
		return extras;
	}
	public void setExtras(Collection<Extras> extras) {
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
