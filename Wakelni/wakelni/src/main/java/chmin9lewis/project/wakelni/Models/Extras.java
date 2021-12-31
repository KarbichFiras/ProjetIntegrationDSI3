package chmin9lewis.project.wakelni.Models;

public class Extras{

	private String name;
	private int quantiteExtras = 1;//lquantite ta3 lextra ili y7ebb 3leha lclient
	private double prixUnitaire;

	public Extras() {
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
