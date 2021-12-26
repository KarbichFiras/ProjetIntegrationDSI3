package chmin9lewis.Restaurants.feane.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Third_Party")
public class ThirdParty extends User{

	public ThirdParty() {
		super();
		// TODO Auto-generated constructor stub
	}

}
