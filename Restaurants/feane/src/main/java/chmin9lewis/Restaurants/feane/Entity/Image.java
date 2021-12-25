package chmin9lewis.Restaurants.feane.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Image implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@NotEmpty
	private String menuImage;
	private String coverImage;
	private String profileImage;
	//nsitha ta3 chnoi hh ken tfakert tw nraj3ouha 
	//private String restImage;
	
	@Column(name="enabled" , columnDefinition = "boolean default true")
	private boolean isEnabled=true;
	@OneToOne
	@JsonIgnore
	private Restaurant restaurant;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Image(@NotEmpty String menuImage, String coverImage, String profileImage, boolean isEnabled) {
		super();
		this.menuImage = menuImage;
		this.coverImage = coverImage;
		this.profileImage = profileImage;
		this.isEnabled = isEnabled;
	}



	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getMenuImage() {
		return menuImage;
	}

	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}
