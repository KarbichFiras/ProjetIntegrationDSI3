package chmin9lewis.Restaurants.feane.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames= {"userName"}))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeUser")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@Column(length=64)
	@NotEmpty
	private String password;
	@Column(name="enabled", columnDefinition = "boolean default true" )
	private boolean isEnabled=true;
	
	@ManyToOne
	// can purchase from many restaurants (forou3 mathalan)
	private Restaurant restaurant;
	
	//USER ROLE RELATION
	@ManyToMany(cascade = CascadeType.ALL , fetch =FetchType.EAGER)
	@JoinTable(name="users_roles" ,
				joinColumns = @JoinColumn(name="user_id") , 
				inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
