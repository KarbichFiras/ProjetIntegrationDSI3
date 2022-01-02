package chmin9lewis.Restaurants.feane.Model;

import java.util.ArrayList;
import java.util.Collection;

public class OrderModel {

	private String ClientUsername;//attribue qui contient le Username du client dans wakalni qui ordered this commande
	private Collection<Product> products = new ArrayList<Product>();
	private double Totale;
	private Long RestaurantCommandeCode;
	
	public OrderModel() {
		super();
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

	public String getClientUsername() {
		return ClientUsername;
	}

	public void setClientUsername(String clientUsername) {
		ClientUsername = clientUsername;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}



}
