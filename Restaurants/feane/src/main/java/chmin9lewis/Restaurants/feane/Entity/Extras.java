package chmin9lewis.Restaurants.feane.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Extras implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@NotEmpty
	private String name;
	private int quantite = 1;
	private double prixUnitaire;
	@Column(name="enabled" , columnDefinition = "boolean default true")
	private boolean isEnabled=true;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "extras")
	@JsonIgnore
	private Collection<FoodWithExtras> foodWithExtras = new ArrayList<FoodWithExtras>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "extras")
	@JsonIgnore
	private Collection<LigneCommandeExtras> ligneCommandeExtras = new ArrayList<LigneCommandeExtras>();
	
	public Extras() {
		super();
	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
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

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Collection<FoodWithExtras> getFoodWithExtras() {
		return foodWithExtras;
	}

	public void setFoodWithExtras(Collection<FoodWithExtras> foodWithExtras) {
		this.foodWithExtras = foodWithExtras;
	}

	public Collection<LigneCommandeExtras> getLigneCommandeExtras() {
		return ligneCommandeExtras;
	}

	public void setLigneCommandeExtras(Collection<LigneCommandeExtras> ligneCommandeExtras) {
		this.ligneCommandeExtras = ligneCommandeExtras;
	}

}
