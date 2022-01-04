package firas.karbich.com.wakalni.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class FoodModel implements Parcelable {

	private String libelle;
	
	private double prix;

	private String image = "images/noFoodImage.jpg";

	private String categorie;
	
	public FoodModel() {
		super();
	}


	protected FoodModel(Parcel in) {
		libelle = in.readString();
		prix = in.readDouble();
		image = in.readString();
		categorie = in.readString();
	}

	public static final Creator<FoodModel> CREATOR = new Creator<FoodModel>() {
		@Override
		public FoodModel createFromParcel(Parcel in) {
			return new FoodModel(in);
		}

		@Override
		public FoodModel[] newArray(int size) {
			return new FoodModel[size];
		}
	};

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(libelle);
		dest.writeDouble(prix);
		dest.writeString(image);
		dest.writeString(categorie);
	}
}
