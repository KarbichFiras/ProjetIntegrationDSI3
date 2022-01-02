package chmin9lewis.project.wakelni.Models;

import java.util.Collection;

public class Order {

	private String ClientUsername;//attribue qui contient le Username du client dans wakalni qui ordered this commande
	private Collection<Product> products;
	private double Totale;
	private Long RestaurantCommandeCode;
	
	public Order() {
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

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public String getClientUsername() {
		return ClientUsername;
	}

	public void setClientUsername(String clientUsername) {
		ClientUsername = clientUsername;
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
