package chmin9lewis.Restaurants.feane.Model;

import java.util.Collection;

import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;

public class Order {

	private String externalClientUsername;//attribue qui contient le Username du client dans wakalni qui ordered this commande
	private String restaurantName;
	private Collection<Plat> plats;
	private float Totale;
	
	public Order() {
		super();
	}

	public String getExternalClientUsername() {
		return externalClientUsername;
	}
	
	public void setExternalClientUsername(String externalClientUsername) {
		this.externalClientUsername = externalClientUsername;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Collection<Plat> getPlats() {
		return plats;
	}

	public void setPlats(Collection<Plat> plats) {
		this.plats = plats;
	}
	public float getTotale() {
		return Totale;
	}

	public void setTotale(float totale) {
		Totale = totale;
	}
}
