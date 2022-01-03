package firas.karbich.com.wakalni.Models;

import java.io.Serializable;

public class ExtrasModel implements Serializable{

	private String name;
	private int quantiteExtras = 1 ;//lquantite ta3 lextra ili y7ebb 3leha lclient
	private double prixUnitaire;

	public ExtrasModel() {
		super();
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
