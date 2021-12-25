package chmin9lewis.project.wakelni.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import chmin9lewis.project.wakelni.Models.Restaurant;

@Entity
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private Date dateFacturation;
	@NotEmpty
	private double total;
	private String modePaiment;
	
	

	private String restaurantAdresse;
	private String restaurantEmail;
	
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Date getDateFacturation() {
		return dateFacturation;
	}

	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getModePaiment() {
		return modePaiment;
	}

	public void setModePaiment(String modePaiment) {
		this.modePaiment = modePaiment;
	}


	public String getRestaurantAdresse() {
		return restaurantAdresse;
	}

	public void setRestaurantAdresse(String restaurantAdresse) {
		this.restaurantAdresse = restaurantAdresse;
	}
	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}
}
