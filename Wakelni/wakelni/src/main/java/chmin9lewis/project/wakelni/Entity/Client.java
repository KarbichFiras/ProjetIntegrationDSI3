package chmin9lewis.project.wakelni.Entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;


@Entity
@DiscriminatorValue("Client")
public class Client extends User{

	@OneToMany(mappedBy = "client")
	private List<Commande> commande;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Long id, @NotEmpty String nom, @NotEmpty String prenom, @NotEmpty String email, @NotEmpty String tel,
			@NotEmpty String adresse) {
		super(id, nom, prenom, email, tel, adresse);
		// TODO Auto-generated constructor stub
	}


	public List<Commande> getCommande() {
		return commande;
	}

	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}

}
