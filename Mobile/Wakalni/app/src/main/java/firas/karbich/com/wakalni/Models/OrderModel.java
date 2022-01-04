package firas.karbich.com.wakalni.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Collection;

public class OrderModel implements Parcelable {

	private String ClientUsername;//attribue qui contient le Username du client dans wakalni qui ordered this commande
	private Collection<ProductModel> products;
	private double Totale;
	private Long RestaurantCommandeCode;
	
	public OrderModel() {
		super();
	}

	protected OrderModel(Parcel in) {
		ClientUsername = in.readString();
		Totale = in.readDouble();
		if (in.readByte() == 0) {
			RestaurantCommandeCode = null;
		} else {
			RestaurantCommandeCode = in.readLong();
		}
	}

	public static final Creator<OrderModel> CREATOR = new Creator<OrderModel>() {
		@Override
		public OrderModel createFromParcel(Parcel in) {
			return new OrderModel(in);
		}

		@Override
		public OrderModel[] newArray(int size) {
			return new OrderModel[size];
		}
	};

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

	public Collection<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(Collection<ProductModel> products) {
		this.products = products;
	}

	public String getClientUsername() {
		return ClientUsername;
	}

	public void setClientUsername(String clientUsername) {
		ClientUsername = clientUsername;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(ClientUsername);
		dest.writeDouble(Totale);
		if (RestaurantCommandeCode == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeLong(RestaurantCommandeCode);
		}
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
