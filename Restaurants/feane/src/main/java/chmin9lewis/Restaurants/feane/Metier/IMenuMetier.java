package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.Menu;

public interface IMenuMetier {

	public Menu getMenuDetails(Long menuCode);
	public List<Menu> getAllMenu();
	public Menu addMenu(Menu menu);
	public Menu updateMenu(Menu menu);
	public boolean deleteMenu(Menu menu);
	public boolean deleteMenuById(Long menuCode);
	public boolean enableMenu(Long menuCode);
	public boolean desableMenu(Long menuCode);
	
}
