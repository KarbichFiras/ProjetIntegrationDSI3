package chmin9lewis.Restaurants.feane.Model;

public class Food {

	private String libelle;
	
	private double prix;
	private String famille;

	private String image = "images/noFoodImage.jpg";

	private String categorie;
	
	public Food() {
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

	public String getFamille() {
		return famille;
	}
	
	public void setFamille(String famille) {
		this.famille = famille;
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
