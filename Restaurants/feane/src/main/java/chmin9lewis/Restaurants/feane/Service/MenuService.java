package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Menu;
import chmin9lewis.Restaurants.feane.Metier.IMenuMetier;

@RestController
public class MenuService {

	@Autowired
	IMenuMetier menuMetier;
	
	@RequestMapping(value="/getMenuDetails/{code}" , method = RequestMethod.GET)
	public Menu getMenuDetails(@PathVariable(name="code") Long menuCode) {
		return menuMetier.getMenuDetails(menuCode);
	}

	@RequestMapping(value="/getAllMenu", method=RequestMethod.GET)
	public List<Menu> getAllMenu() {
		return menuMetier.getAllMenu();
	}

	@RequestMapping(value="/addMenu", method=RequestMethod.POST)
	public Menu addMenu(@RequestBody Menu menu) {
		return menuMetier.addMenu(menu);
	}

	@RequestMapping(value="/updateMenu", method=RequestMethod.PUT)
	public Menu updateMenu(@RequestBody Menu menu) {
		return menuMetier.updateMenu(menu);
	}

	@RequestMapping(value="/deleteMenu", method=RequestMethod.DELETE)
	public boolean deleteMenu(@RequestBody Menu menu) {
		return menuMetier.deleteMenu(menu);
	}

	@RequestMapping(value="/deleteMenuById/{code}", method=RequestMethod.DELETE)
	public boolean deleteMenuById(@RequestBody Long menuCode) {
		return menuMetier.deleteMenuById(menuCode);
	}

	@RequestMapping(value="/enableMenu/{code}", method=RequestMethod.PUT)
	public boolean enableMenu(@PathVariable(name="code") Long menuCode) {
		return menuMetier.enableMenu(menuCode);
	}

	@RequestMapping(value="/desableMenu/{code}", method=RequestMethod.PUT)
	public boolean desableMenu(@PathVariable(name="code") Long menuCode) {
		return menuMetier.desableMenu(menuCode);
	}
	
}
