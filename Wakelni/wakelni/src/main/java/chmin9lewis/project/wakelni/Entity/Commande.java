package chmin9lewis.project.wakelni.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Commande {
/**/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCommande;
	private Date  dateCreattion;
	@NotEmpty
	private String adresseLivraison;
	
	@ManyToOne
	private Client client;
	
	/*@ManyToOne
	private DeliveryMan deliveryMan;*/
	@OneToMany (targetEntity = Facture.class)
	@JoinColumn(name="Commande_idFK",referencedColumnName="codeCommande")
	private List<Facture> facture;
	
	
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
/*
	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}*/

	public List<Facture> getFacture() {
		return facture;
	}

	public void setFacture(List<Facture> facture) {
		this.facture = facture;
	}

	
	
}
//

