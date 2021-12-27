package chmin9lewis.project.wakelni.Models;

import java.util.Collection;

public class Order {

	private String externalClientUsername;//attribue qui contient le Username du client dans wakalni qui ordered this commande
	private String restaurantName;
	private Collection<Plat> plats;
	private double Totale;
	private Long RestaurantCommandeCode;
	
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
	
	/*
	 * Order on json !! FROM WAKALNI !!
	 * 
	   {
		    "externalClientUsername": "externalClientUsername test :p",
		    "restaurantName": "restaurantName test :p",
		    "plats": [
		        {
		            "extras": [
		                {
		                    "name": "MAYONNAISE",
		                    "quantiteExtras" : 2
		                },
		                {
		                    "name": "bsal",
		                    "quantiteExtras" : 3
		                }
		            ],
		            "food": {
		                "libelle": "mlaoui"
		            }
		        },
		        {
		            "extras": [
		                {
		                    "name": "bsal",
		                    "quantiteExtras" : 4
		                }
		            ],
		            "food": {
		                "libelle": "lablebi"
		            }
		        }
		    ]
		}
		
	 */
	
}
