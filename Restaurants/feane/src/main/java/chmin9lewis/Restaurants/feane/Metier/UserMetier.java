package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.User;
import chmin9lewis.Restaurants.feane.Repository.UserRepository;

@Service
public class UserMetier implements IUserMetier{

	@Autowired
	UserRepository userRepository;

	//CURRENT LOGED IN USER
	@Override
	public User getLoggedUser() {
		Authentication loggedInUser;
	    try {
	    	loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    	return userRepository.findByUserName(loggedInUser.getName());
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	    
	}
	
	@Override
	public User getUserDetails(Long userId) {
		try {
			return userRepository.findById(userId).get();
		}catch(Exception e) {
			System.out.println("Could not find any user with this id : " + userId);
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {
		try {
			return userRepository.findAll();
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public User addUser(User user) {
		try {
			return userRepository.save(user);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public User updateUser(User user) {
		try {
			return userRepository.save(user);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			userRepository.delete(user);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean deleteUserById(Long userId) {
		try {
			userRepository.deleteById(userId);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean enableUser(Long userId) {
		try {
			User user = userRepository.findById(userId).get();
			user.setEnabled(true);
			updateUser(user);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any extras with this id : " + userId);
			return false;
		}
	}

	@Override
	public boolean desableUser(Long userId) {
		try {
			User user = userRepository.findById(userId).get();
			user.setEnabled(false);
			updateUser(user);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any extras with this id : " + userId);
			return false;
		}
	}

}
