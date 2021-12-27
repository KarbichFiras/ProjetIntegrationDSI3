package chmin9lewis.Restaurants.feane.Entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "employeId")
public class Employe extends User{

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

}
