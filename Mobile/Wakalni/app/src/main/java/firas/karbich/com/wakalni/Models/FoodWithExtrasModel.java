package firas.karbich.com.wakalni.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class FoodWithExtrasModel implements Parcelable {
	
	private Long code;
	private Collection<ExtrasModel> extras =  new ArrayList<ExtrasModel>(); 
	private FoodModel food;
	
	public FoodWithExtrasModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected FoodWithExtrasModel(Parcel in) {
		if (in.readByte() == 0) {
			code = null;
		} else {
			code = in.readLong();
		}
	}

	public static final Creator<FoodWithExtrasModel> CREATOR = new Creator<FoodWithExtrasModel>() {
		@Override
		public FoodWithExtrasModel createFromParcel(Parcel in) {
			return new FoodWithExtrasModel(in);
		}

		@Override
		public FoodWithExtrasModel[] newArray(int size) {
			return new FoodWithExtrasModel[size];
		}
	};

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}

	public Collection<ExtrasModel> getExtras() {
		return extras;
	}

	public void setExtras(Collection<ExtrasModel> extras) {
		this.extras = extras;
	}

	public FoodModel getFood() {
		return food;
	}

	public void setFood(FoodModel food) {
		this.food = food;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		if (code == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeLong(code);
		}
	}
}