package chmin9lewis.Restaurants.feane.Entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "thirdPartyId")
public class ThirdParty extends User{

	public ThirdParty() {
		super();
		// TODO Auto-generated constructor stub
	}

}
