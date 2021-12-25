package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Extras;
import chmin9lewis.Restaurants.feane.Metier.IExtrasMetier;

@RestController
@CrossOrigin
public class ExtrasService {

	@Autowired
	IExtrasMetier ExtrasMetier;
	
	@RequestMapping(value="/getExtrasDetails/{code}", method=RequestMethod.GET)
	public Extras getExtrasDetails(@PathVariable(name="code") Long extrasCode) {
		return ExtrasMetier.getExtrasDetails(extrasCode);
	}

	@RequestMapping(value="/getAllExtras", method=RequestMethod.GET)
	public List<Extras> getAllExtras() {
		return ExtrasMetier.getAllExtras();
	}

	@RequestMapping(value="/addExtras", method=RequestMethod.POST)
	public Extras addExtras(@RequestBody Extras extras) {
		return ExtrasMetier.addExtras(extras);
	}

	@RequestMapping(value="/updateExtras", method=RequestMethod.PUT)
	public Extras updateExtras(@RequestBody Extras extras) {
		return ExtrasMetier.updateExtras(extras);
	}
	
	@RequestMapping(value="/deleteExtras", method=RequestMethod.DELETE)
	public boolean deleteExtras(@RequestBody Extras extras) {
		return ExtrasMetier.deleteExtras(extras);
	}

	@RequestMapping(value="/deleteExtrasById/{code}", method=RequestMethod.DELETE)
	public boolean deleteExtrasById(@PathVariable(name="code") Long extrasCode) {
		return ExtrasMetier.deleteExtrasById(extrasCode);
	}

	@RequestMapping(value="/enableExtras/{code}", method=RequestMethod.PUT)
	public boolean enableExtras(@PathVariable(name="code") Long extrasCode) {
		return ExtrasMetier.enableExtras(extrasCode);
	}

	@RequestMapping(value="/desableExtras/{code}", method=RequestMethod.PUT)
	public boolean desableExtras(@PathVariable(name="code") Long extrasCode) {
		return ExtrasMetier.desableExtras(extrasCode);
	}
	
}
