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

@Entity
public class LigneCommandeExtras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;

	@ManyToOne
	private Extras extras;

	@ManyToOne
	private LigneCommande ligneCommande;
	
	public LigneCommandeExtras() {
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

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

}
