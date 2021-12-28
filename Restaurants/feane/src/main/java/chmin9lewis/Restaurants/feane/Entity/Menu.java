package chmin9lewis.Restaurants.feane.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Menu implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@NotEmpty
	//Examples : valontine Menu, chrismass menu, weekend Menu, etc
	private String titre;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" , insertable = false, updatable = false)
	private Date createdAt;
	@Column(name="enabled" , columnDefinition = "boolean default true")
	private boolean isEnabled = true;
	
	@OneToMany(mappedBy = "menu")
	private Collection<Food> menuFoods = new ArrayList<Food>();

	//Menu Restaurant RELATION
	@ManyToOne
	private Restaurant restaurant;
		
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Collection<Food> getMenuFoods() {
		return menuFoods;
	}

	public void setMenuFoods(Collection<Food> menuFoods) {
		this.menuFoods = menuFoods;
	}

}
