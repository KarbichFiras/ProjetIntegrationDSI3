package chmin9lewis.project.wakelni.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facture implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" , insertable = false, updatable = false)
	private Date dateFacturation;
	private double total;
	private String modePaiment;
	private Long RestaurantCommandeCode;// najmou nesta3mlou lcode ta3 lcommande wbih nal9aw lrestaurant 
	
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

	public Long getRestaurantCommandeCode() {
		return RestaurantCommandeCode;
	}

	public void setRestaurantCommandeCode(Long restaurantCommandeCode) {
		RestaurantCommandeCode = restaurantCommandeCode;
	}
}
