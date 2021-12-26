package chmin9lewis.project.wakelni.Models;

import java.util.Collection;

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
	
	/*
	 * Order on json !! FROM WAKALNI !!
	 * {
	    "externalClientUsername": "externalClientUsername test :p",
	    "restaurantName": "restaurantName test :p",
	    "plats": [
	        {
	            "extras": {
	                "name": "mayonnaise"
	            },
	            "food": {
	                "libelle": "mlaoui"
	            }
	        },
	        {
	            "extras": {
	                "name": "bsal"
	            },
	            "food": {
	                "libelle": "mlaoui"
	            }
	        }
	    ]
	}
	 */
	
}
