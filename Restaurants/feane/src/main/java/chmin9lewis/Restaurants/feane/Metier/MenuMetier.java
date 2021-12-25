package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Menu;
import chmin9lewis.Restaurants.feane.Repository.MenuRepository;

@Service
public class MenuMetier implements IMenuMetier{

	@Autowired
	MenuRepository menuRepository;
	
	@Override
	public Menu getMenuDetails(Long menuCode) {
		try {
			return menuRepository.findById(menuCode).get();
		}catch(Exception e) {
			System.out.println("Could not find any menu with this id : " + menuCode);
			return null;
		}
	}

	@Override
	public List<Menu> getAllMenu() {
		try {
			return menuRepository.findAll();
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Menu addMenu(Menu menu) {
		try {
			return menuRepository.save(menu);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Menu updateMenu(Menu menu) {
		try {
			return menuRepository.save(menu);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public boolean deleteMenu(Menu menu) {
		try {
			menuRepository.delete(menu);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean deleteMenuById(Long menuCode) {
		try {
			menuRepository.deleteById(menuCode);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean enableMenu(Long menuCode) {
		try {
			Menu menu = menuRepository.findById(menuCode).get();
			menu.setEnabled(true);
			updateMenu(menu);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any menu with this id : " + menuCode);
			return false;
		}
	}

	@Override
	public boolean desableMenu(Long menuCode) {
		try {
			Menu menu = menuRepository.findById(menuCode).get();
			menu.setEnabled(false);
			updateMenu(menu);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any menu with this id : " + menuCode);
			return false;
		}
	}

}
