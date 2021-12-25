package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Categorie;
import chmin9lewis.Restaurants.feane.Repository.CategorieRepository;

@Service
public class CategorieMetier implements ICategorieMetier{
	
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public Categorie getCategorieDetails(Long categorieCode) {
		try {
			return categorieRepository.findById(categorieCode).get();
		}catch(Exception e) {
			System.out.println("Could not find any categorie with this id : " + categorieCode);
			return null;
		}
	}

	@Override
	public List<Categorie> getAllCategorie() {
		try {
			return categorieRepository.findAll();
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Categorie addCategorie(Categorie categorie) {
		try {
			return categorieRepository.save(categorie);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		try {
			return categorieRepository.save(categorie);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public boolean deleteCategorie(Categorie categorie) {
		try {
			categorieRepository.delete(categorie);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean deleteCategorieById(Long categorieCode) {
		try {
			categorieRepository.deleteById(categorieCode);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean enableCategorie(Long categorieCode) {
		try {
			Categorie categorie = categorieRepository.findById(categorieCode).get();
			categorie.setEnabled(true);
			updateCategorie(categorie);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any categorie with this id : " + categorieCode);
			return false;
		}
	}

	@Override
	public boolean desableCategorie(Long categorieCode) {
		try {
			Categorie categorie = categorieRepository.findById(categorieCode).get();
			categorie.setEnabled(false);
			updateCategorie(categorie);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any categorie with this id : " + categorieCode);
			return false;
		}
	}

}
