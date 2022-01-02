package chmin9lewis.project.wakelni.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Menu implements Serializable{

	private Long code;
	private String titre;
	private Date createdAt;
	private String restaurantName;
	private Collection<FoodWithExtras> menuFoods = new ArrayList<FoodWithExtras>();
		
	public Menu() {
		super();
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

	public Collection<FoodWithExtras> getMenuFoods() {
		return menuFoods;
	}

	public void setMenuFoods(Collection<FoodWithExtras> menuFoods) {
		this.menuFoods = menuFoods;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
}
