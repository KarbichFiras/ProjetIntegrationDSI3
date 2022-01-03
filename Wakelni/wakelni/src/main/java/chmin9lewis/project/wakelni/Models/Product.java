package chmin9lewis.project.wakelni.Models;

public class Product {

	private String code; // concatination ta3 restau name et food name ( ili houwame7chi ta7t lfoud with extra )
	private FoodWithExtras foodWithExtras;
	private int quantiteFoodWithExtras;
	private double prixFinale;
	private String restaurantName;
	
	public Product() {
		super();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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

	public FoodWithExtras getFoodWithExtras() {
		return foodWithExtras;
	}

	public void setFoodWithExtras(FoodWithExtras foodWithExtras) {
		this.foodWithExtras = foodWithExtras;
	}

	public int getQuantiteFoodWithExtras() {
		return quantiteFoodWithExtras;
	}

	public void setQuantiteFoodWithExtras(int quantiteFoodWithExtras) {
		this.quantiteFoodWithExtras = quantiteFoodWithExtras;
	}
	
	
	
}
