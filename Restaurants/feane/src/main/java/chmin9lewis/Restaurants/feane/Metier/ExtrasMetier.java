package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Extras;
import chmin9lewis.Restaurants.feane.Repository.ExtrasRepository;

@Service
public class ExtrasMetier implements IExtrasMetier {

	@Autowired
	ExtrasRepository extrasRepository;

	@Override
	public Extras getExtrasDetails(Long extrasCode) {
		try {
			return extrasRepository.findById(extrasCode).get();
		}catch(Exception e) {
			System.out.println("Could not find any extras with this id : " + extrasCode);
			return null;
		}
	}

	@Override
	public List<Extras> getAllExtras() {
		try {
			return extrasRepository.findAll();
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Extras addExtras(Extras extras) {
		try {
			return extrasRepository.save(extras);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Extras updateExtras(Extras extras) {
		try {
			return extrasRepository.save(extras);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public boolean deleteExtras(Extras extras) {
		try {
			extrasRepository.delete(extras);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean deleteExtrasById(Long extrasCode) {
		try {
			extrasRepository.deleteById(extrasCode);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean enableExtras(Long extrasCode) {
		try {
			Extras extras = extrasRepository.findById(extrasCode).get();
			extras.setEnabled(true);
			updateExtras(extras);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any extras with this id : " + extrasCode);
			return false;
		}
	}

	@Override
	public boolean desableExtras(Long extrasCode) {
		try {
			Extras extras = extrasRepository.findById(extrasCode).get();
			extras.setEnabled(false);
			updateExtras(extras);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any extras with this id : " + extrasCode);
			return false;
		}
	}

	@Override
	public Extras getExtrasByName(String extrasName) {
		try {
			return extrasRepository.findByName(extrasName);
		}catch(Exception e) {
			System.out.println("Could not find any extras with this name : " + extrasName);
			return null;
		}
	}
	
	
	
}
