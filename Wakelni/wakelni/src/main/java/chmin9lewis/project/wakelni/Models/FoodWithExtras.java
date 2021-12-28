package chmin9lewis.project.wakelni.Models;

import java.io.Serializable;

public class FoodWithExtras implements Serializable{
	
	private Long code;
	private Extras extras;
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
	public Extras getExtras() {
		return extras;
	}
	public void setExtras(Extras extras) {
		this.extras = extras;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}

}