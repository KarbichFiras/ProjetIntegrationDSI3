package chmin9lewis.project.wakelni.Entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
@DiscriminatorValue("DeliveryMan")
public class DeliveryMan extends User{	

	@OneToMany(mappedBy = "deliveryMan")
	private List<Commande> commande;
	
	public DeliveryMan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Commande> getCommande() {
		return commande;
	}

	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}
	
}
