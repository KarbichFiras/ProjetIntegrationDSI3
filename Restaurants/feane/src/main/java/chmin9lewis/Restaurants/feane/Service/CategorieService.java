package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Categorie;
import chmin9lewis.Restaurants.feane.Metier.ICategorieMetier;

@RestController
public class CategorieService {

	@Autowired
	ICategorieMetier categorieMetier;
	
	
	@RequestMapping(value="/getCategorieDetails/{code}", method=RequestMethod.GET)
	public Categorie getCategorieDetails(@PathVariable(name="code") Long categorieCode) {
		return categorieMetier.getCategorieDetails(categorieCode);
	}

	@RequestMapping(value="/getAllCategorie", method=RequestMethod.GET)
	public List<Categorie> getAllCategorie() {
		return categorieMetier.getAllCategorie();
	}

	@RequestMapping(value="/addCategorie", method=RequestMethod.POST)
	public Categorie addCategorie(@RequestBody Categorie categorie) {
		return categorieMetier.addCategorie(categorie);
	}

	@RequestMapping(value="/updateCategorie", method=RequestMethod.PUT)
	public Categorie updateCategorie(@RequestBody Categorie categorie) {
		return categorieMetier.updateCategorie(categorie);
	}

	@RequestMapping(value="/deleteCategorie", method=RequestMethod.DELETE)
	public boolean deleteCategorie(@RequestBody Categorie categorie) {
		return categorieMetier.deleteCategorie(categorie);
	}

	@RequestMapping(value="/deleteCategorieById/{code}", method=RequestMethod.DELETE)
	public boolean deleteCategorieById(@PathVariable(name="code") Long categorieCode) {
		return categorieMetier.deleteCategorieById(categorieCode);
	}

	@RequestMapping(value="/enableCategorie/{code}", method=RequestMethod.PUT)
	public boolean enableCategorie(@PathVariable(name="code") Long categorieCode) {
		return categorieMetier.enableCategorie(categorieCode);
	}

	@RequestMapping(value="/desableCategorie/{code}", method=RequestMethod.PUT)
	public boolean desableCategorie(@PathVariable(name="code") Long categorieCode) {
		return categorieMetier.desableCategorie(categorieCode);
	}

}
