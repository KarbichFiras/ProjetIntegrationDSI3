package chmin9lewis.project.wakelni.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Employe")
public class Employe extends User {

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

}
