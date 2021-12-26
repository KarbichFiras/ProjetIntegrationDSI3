package chmin9lewis.project.wakelni.Metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import chmin9lewis.project.wakelni.Entity.Role;
import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Repository.RoleRepository;
import chmin9lewis.project.wakelni.Repository.UserRepository;


@Service
public class UserMetier implements IUserMetier {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public User addUser(User user) {
		try {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String encodedPassword = encoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			
			/*Role role = roleRepository.findByName("Client");
	        user.getRoles().add(role);*/
			return userRepository.save(user);
			
		}catch(Exception e) {
			System.out.println("Could not add this User! ");
			e.printStackTrace();
			return null;
		}
	}

	//CURRENT LOGED IN USER
	@Override
	public User getLoggedUser() {
			
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 

	    User user = new User() ;
	    
	    try {
	    	user = userRepository.findByUserName(username);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		    
	  return user;
			
	}
}
