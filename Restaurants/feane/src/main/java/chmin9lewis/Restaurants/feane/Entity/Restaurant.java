package chmin9lewis.Restaurants.feane.Entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames= {"name"}))
public class Restaurant implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@NotEmpty
	private String name;
	@NotEmpty
	private String adresse;
	@NotEmpty
	private String email;
	@Column(name="enabled", columnDefinition = "boolean default true" )
	private boolean isEnabled=true;
	
	@OneToOne
	private Image image;
	
	@OneToMany(mappedBy = "restaurant")
	private Collection<User> employees;
	
	@OneToMany(mappedBy = "restaurant")
	private Collection<Menu> menus;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isEnabled() {
		return isEnabled;
	}


	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Collection<User> getEmployees() {
		return employees;
	}


	public void setEmployees(Collection<User> employees) {
		this.employees = employees;
	}


	public Collection<Menu> getMenus() {
		return menus;
	}


	public void setMenus(Collection<Menu> menus) {
		this.menus = menus;
	}
}
