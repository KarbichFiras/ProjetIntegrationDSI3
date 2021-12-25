package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.Categorie;

public interface ICategorieMetier {

	public Categorie getCategorieDetails(Long categorieCode);
	public List<Categorie> getAllCategorie();
	public Categorie addCategorie(Categorie categorie);
	public Categorie updateCategorie(Categorie categorie);
	public boolean deleteCategorie(Categorie categorie);
	public boolean deleteCategorieById(Long categorieCode);
	public boolean enableCategorie(Long categorieCode);
	public boolean desableCategorie(Long categorieCode);
	
}
