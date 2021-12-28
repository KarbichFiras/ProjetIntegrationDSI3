package chmin9lewis.Restaurants.feane.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames= {"libelle"}))
public class Food implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@NotEmpty
	private String libelle;
	
	private double prix;
	@Column(name="enabled" , columnDefinition = "boolean default true")
	private boolean isEnabled=true;

	private String image = "images/noFoodImage.jpg";
	
	//FOOD FoodWithExtras RELATION
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "food")
	@JsonIgnore
	private List<FoodWithExtras> foodWithExtras = new ArrayList<FoodWithExtras>();
	
	//FOOD Categorie RELATION
	@ManyToOne
	private Categorie categorie;
	
	
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
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
	
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<FoodWithExtras> getFoodWithExtras() {
		return foodWithExtras;
	}

	public void setFoodWithExtras(List<FoodWithExtras> foodWithExtras) {
		this.foodWithExtras = foodWithExtras;
	}
}
