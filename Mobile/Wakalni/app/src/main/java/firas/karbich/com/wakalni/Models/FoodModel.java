package firas.karbich.com.wakalni.Models;

import java.io.Serializable;

public class FoodModel implements Serializable{

	private String libelle;
	
	private double prix;

	private String image = "images/noFoodImage.jpg";

	private String categorie;
	
	public FoodModel() {
		super();
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
