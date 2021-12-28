package chmin9lewis.project.wakelni.Models;

import java.util.ArrayList;
import java.util.Collection;

public class Restaurant {

	private Long code;
	private String name;
	private String adresse;
	private String email;
	private String description;
	private Image image;
	private Collection<Menu> menus = new ArrayList<Menu>();
	
	
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public Collection<Menu> getMenus() {
		return menus;
	}


	public void setMenus(Collection<Menu> menus) {
		this.menus = menus;
	}
	
}
