package chmin9lewis.Restaurants.feane.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private int quantite = 1; 
	
	@ManyToOne
	private Commande commande;
	
	@ManyToOne
	private FoodWithExtras foodWithExtras;

	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public FoodWithExtras getFoodWithExtras() {
		return foodWithExtras;
	}

	public void setFoodWithExtras(FoodWithExtras foodWithExtras) {
		this.foodWithExtras = foodWithExtras;
	}

}
