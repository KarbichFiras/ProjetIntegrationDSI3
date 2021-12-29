package chmin9lewis.project.wakelni.Models;

import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import chmin9lewis.project.wakelni.Entity.User;

public class Register {
	
	private Long id;
	@NotBlank
	@Size(min=3, max=50 )
	private String username;
	
	private String nom;
	
	private String prenom;
	@Email
	private String email;
	
	private String adresse;
	
	private String tel;

	private String password;
	
	private Set<String> roles;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(User user) {
		super();
		this.id=user.getId();
		this.username=user.getUsername();
		this.nom=user.getNom();
		this.prenom=user.getPrenom();
		this.email=user.getEmail();
		this.adresse=user.getAdresse();
		this.tel=user.getTel();
		this.password=user.getPassword();
		//this.roles.add("CLIENT");
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
