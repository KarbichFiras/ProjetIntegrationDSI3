package chmin9lewis.project.wakelni.Models;

import com.fasterxml.jackson.annotation.JsonAlias;

//ch9af bich nista3mlouh wa9t t3adi id ta3  restaurant bich yjib les food ili teb3ino
public class FoodExtrasCategorieModel {
	
	 String namer;
	 String libelle;
	 double tprix;
	 String image;
	 
	 String namec;

	

	 String nameex;
	 Long quantite;
	 double prix_unitaire;
	 
	public String getNamer() {
		return namer;
	}
	public FoodExtrasCategorieModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setNamer(String namer) {
		this.namer = namer;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getTprix() {
		return tprix;
	}
	public void setTprix(double tprix) {
		this.tprix = tprix;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNamec() {
		return namec;
	}
	public void setNamec(String namec) {
		this.namec = namec;
	}
	public String getNameex() {
		return nameex;
	}
	public void setNameex(String nameex) {
		this.nameex = nameex;
	}
	public Long getQuantite() {
		return quantite;
	}
	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}
	public double getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(double prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
	
}

