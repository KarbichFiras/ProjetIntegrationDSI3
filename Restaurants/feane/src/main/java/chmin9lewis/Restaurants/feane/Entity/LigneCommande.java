package chmin9lewis.Restaurants.feane.Entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class LigneCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private int quantite = 1; 
	
	@ManyToOne
	private Commande commande;

	@OneToOne
	private Food food;
	
	@OneToMany( mappedBy = "ligneCommande")
	private Collection<LigneCommandeExtras> ligne_commande_extras = new ArrayList<LigneCommandeExtras>();
	
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

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Collection<LigneCommandeExtras> getLigne_commande_extras() {
		return ligne_commande_extras;
	}

	public void setLigne_commande_extras(Collection<LigneCommandeExtras> ligne_commande_extras) {
		this.ligne_commande_extras = ligne_commande_extras;
	}

}
