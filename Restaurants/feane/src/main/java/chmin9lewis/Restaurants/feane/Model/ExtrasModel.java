package chmin9lewis.Restaurants.feane.Model;

import chmin9lewis.Restaurants.feane.Entity.Extras;

public class ExtrasModel{

	private String name;
	private int quantiteExtras = 1 ;//lquantite ta3 lextra ili y7ebb 3leha lclient
	private double prixUnitaire;

	public ExtrasModel() {
		super();
	}
	
	// create objet ExtrasModel from an object Extras
	public ExtrasModel(Extras extras) {
		this.name = extras.getName();
		this.quantiteExtras = extras.getQuantite();
		this.prixUnitaire = extras.getPrixUnitaire();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getQuantiteExtras() {
		return quantiteExtras;
	}

	public void setQuantiteExtras(int quantiteExtras) {
		this.quantiteExtras = quantiteExtras;
	}
}
