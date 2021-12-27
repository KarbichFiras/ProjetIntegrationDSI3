package chmin9lewis.project.wakelni.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Commande implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCommande;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" , insertable = false, updatable = false)
	private Date  dateCreattion;
	@NotEmpty
	private String adresseLivraison;
	
	@ManyToOne
	private User client;// directeur ynajim fil weekend mathalan y7el bil account mte3ou wya9thi normal sinn twali 3andou restau wyechri mil barra doesn't make sense!
	
	@ManyToOne
	private DeliveryMan deliveryMan;
	
	@OneToOne
	private Facture facture;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getCodeCommande() {
		return codeCommande;
	}

	public void setCodeCommande(Long codeCommande) {
		this.codeCommande = codeCommande;
	}

	public Date getDateCreattion() {
		return dateCreattion;
	}

	public void setDateCreattion(Date dateCreattion) {
		this.dateCreattion = dateCreattion;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
}
