package chmin9lewis.project.wakelni.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class FoodWithExtras implements Serializable{
	
	private Long code;
	private Collection<Extras> extras = new ArrayList<Extras>(); // hethi twali collection ta3 extras 
	private Food food;
	
	public FoodWithExtras() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}

	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}

	public Collection<Extras> getExtras() {
		return extras;
	}

	public void setExtras(Collection<Extras> extras) {
		this.extras = extras;
	}

}