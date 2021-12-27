package chmin9lewis.Restaurants.feane.Model;

import java.util.Collection;

public class OrderModel {

	private String externalClientUsername;//attribue qui contient le Username du client dans wakalni qui ordered this commande
	private String restaurantName;
	private Collection<PlatModel> plats;
	private double Totale;
	private Long RestaurantCommandeCode;
	
	public OrderModel() {
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

	public Collection<PlatModel> getPlats() {
		return plats;
	}

	public void setPlats(Collection<PlatModel> plats) {
		this.plats = plats;
	}
	public double getTotale() {
		return Totale;
	}

	public void setTotale(double totale) {
		Totale = totale;
	}

	public Long getRestaurantCommandeCode() {
		return RestaurantCommandeCode;
	}

	public void setRestaurantCommandeCode(Long restaurantCommandeCode) {
		RestaurantCommandeCode = restaurantCommandeCode;
	}
}
