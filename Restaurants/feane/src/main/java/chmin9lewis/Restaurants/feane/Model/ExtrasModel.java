package chmin9lewis.Restaurants.feane.Model;

public class ExtrasModel{

	private Long codeex;

	private String name;
	private int quantiteExtras = 1 ;//lquantite ta3 lextra ili y7ebb 3leha lclient
	private double prixUnitaire;

	public ExtrasModel() {
		super();
	}
	public Long getCodeex() {
		return codeex;
	}

	public void setCodeex(Long codeex) {
		this.codeex = codeex;
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
