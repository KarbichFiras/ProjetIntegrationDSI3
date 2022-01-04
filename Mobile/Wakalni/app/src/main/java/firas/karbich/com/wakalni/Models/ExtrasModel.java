package firas.karbich.com.wakalni.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ExtrasModel implements Parcelable {

	private String name;
	private int quantiteExtras = 1 ;//lquantite ta3 lextra ili y7ebb 3leha lclient
	private double prixUnitaire;

	public ExtrasModel() {
		super();
	}

	protected ExtrasModel(Parcel in) {
		name = in.readString();
		quantiteExtras = in.readInt();
		prixUnitaire = in.readDouble();
	}

	public static final Creator<ExtrasModel> CREATOR = new Creator<ExtrasModel>() {
		@Override
		public ExtrasModel createFromParcel(Parcel in) {
			return new ExtrasModel(in);
		}

		@Override
		public ExtrasModel[] newArray(int size) {
			return new ExtrasModel[size];
		}
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getQuantiteExtras() {
		return quantiteExtras;
	}

	public void setQuantiteExtras(int quantiteExtras) {
		this.quantiteExtras = quantiteExtras;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeInt(quantiteExtras);
		dest.writeDouble(prixUnitaire);
	}
}
