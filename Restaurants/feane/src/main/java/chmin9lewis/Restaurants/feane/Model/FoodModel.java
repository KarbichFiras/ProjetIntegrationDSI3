package chmin9lewis.Restaurants.feane.Model;

import chmin9lewis.Restaurants.feane.Entity.Food;

public class FoodModel {

	private String libelle;
	
	private double prix;

	private String image = "images/noFoodImage.jpg";

	private String categorie;
	
	public FoodModel() {
		super();
	}

	// create un oobjet de type FoodModel from un objet Food ( Food ili houwa lentity)
	public FoodModel(Food food) {
		this.libelle = food.getLibelle();
		this.prix = food.getPrix();
		this.image = food.getImage();
		this.categorie = food.getCategorie().getName();
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
}
