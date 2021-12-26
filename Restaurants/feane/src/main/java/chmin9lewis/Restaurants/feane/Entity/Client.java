package chmin9lewis.Restaurants.feane.Entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Client")
public class Client extends User{
	


	// attributte qui indique que ce client est crrer dans un thirdParty comme "wakalni"
	@Column(columnDefinition = "boolean default false" )
	private boolean external = false;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isExternal() {
		return external;
	}

	public void setExternal(boolean external) {
		this.external = external;
	}
}
