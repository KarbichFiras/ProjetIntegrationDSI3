package chmin9lewis.Restaurants.feane.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private double prixUnitaire;
	@Column(name="enabled" , columnDefinition = "boolean default true")
	private boolean isEnabled=true;
	
	@OneToMany(mappedBy = "extras")
	@JsonIgnore
	private List<FoodWithExtras> foodWithExtras;

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

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public List<FoodWithExtras> getFoodWithExtras() {
		return foodWithExtras;
	}

	public void setFoodWithExtras(List<FoodWithExtras> foodWithExtras) {
		this.foodWithExtras = foodWithExtras;
	}
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}
