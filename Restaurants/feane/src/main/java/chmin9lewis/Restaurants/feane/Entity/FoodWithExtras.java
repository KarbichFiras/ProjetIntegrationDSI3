package chmin9lewis.Restaurants.feane.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FoodWithExtras implements Serializable{
	
	// This Entity (table) lgeron mathalan y3abiha.Y7ot fiha par example lablebi w les extras ili yerkbou 3al lablebi ( bitbi3a lablbi w9odem ka3ba extras bch tkoun fil DB surplusieur lignes)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@Column(name="enabled" , columnDefinition = "boolean default true")
	private boolean isEnabled=true;
	
	@ManyToOne
	private Extras extras;
	@ManyToOne
	private Food food;

	//FoodWithExtras Menu RELATION
	@ManyToOne
	private Menu menu;
	
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

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
