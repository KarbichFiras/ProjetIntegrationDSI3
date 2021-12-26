package chmin9lewis.project.wakelni.Entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;


@Entity
@DiscriminatorValue("Client")
public class Client extends User{
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

}
