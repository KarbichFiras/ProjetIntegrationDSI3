package firas.karbich.com.wakalni.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class FoodWithExtrasModel implements Serializable{
	
	private Long code;
	private Collection<ExtrasModel> extras =  new ArrayList<ExtrasModel>(); 
	private FoodModel food;
	
	public FoodWithExtrasModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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


}