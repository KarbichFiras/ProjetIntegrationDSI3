package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;
import chmin9lewis.Restaurants.feane.Repository.FoodWithExtrasRepository;

@Service
public class FoodWithExtrasMetier implements IFoodWithExtrasMetier{

	@Autowired
	FoodWithExtrasRepository foodWithExtrasRepository;

	@Override
	public FoodWithExtras getFoodWithExtrasDetails(Long foodWithExtrasCode) {
		try {
			return foodWithExtrasRepository.findById(foodWithExtrasCode).get();
		}catch(Exception e) {
			System.out.println("Could not find any foodWithExtras with this id : " + foodWithExtrasCode);
			return null;
		}
	}

	@Override
	public List<FoodWithExtras> getAllFoodWithExtras() {
		try {
			return foodWithExtrasRepository.findAll();
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public FoodWithExtras addFoodWithExtras(FoodWithExtras foodWithExtras) {
		try {
			return foodWithExtrasRepository.save(foodWithExtras);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public FoodWithExtras updateFoodWithExtras(FoodWithExtras foodWithExtras) {
		try {
			return foodWithExtrasRepository.save(foodWithExtras);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public boolean deleteFoodWithExtras(FoodWithExtras foodWithExtras) {
		try {
			foodWithExtrasRepository.delete(foodWithExtras);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean deleteFoodWithExtrasById(Long foodWithExtrasCode) {
		try {
			foodWithExtrasRepository.deleteById(foodWithExtrasCode);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean enableFoodWithExtras(Long foodWithExtrasCode) {
		try {
			FoodWithExtras foodWithExtras = foodWithExtrasRepository.findById(foodWithExtrasCode).get();
			foodWithExtras.setEnabled(true);
			updateFoodWithExtras(foodWithExtras);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any foodWithExtras with this id : " + foodWithExtrasCode);
			return false;
		}
	}

	@Override
	public boolean desableFoodWithExtras(Long foodWithExtrasCode) {
		try {
			FoodWithExtras foodWithExtras = foodWithExtrasRepository.findById(foodWithExtrasCode).get();
			foodWithExtras.setEnabled(false);
			updateFoodWithExtras(foodWithExtras);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any foodWithExtras with this id : " + foodWithExtrasCode);
			return false;
		}
	}
	
	
	
}
