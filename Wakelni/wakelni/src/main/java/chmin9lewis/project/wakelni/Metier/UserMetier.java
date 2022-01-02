package chmin9lewis.project.wakelni.Metier;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import chmin9lewis.project.wakelni.Entity.Client;
import chmin9lewis.project.wakelni.Entity.Employe;
import chmin9lewis.project.wakelni.Entity.Role;
import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Models.Register;
import chmin9lewis.project.wakelni.Repository.RoleRepository;
import chmin9lewis.project.wakelni.Repository.UserRepository;


@Service
public class UserMetier implements IUserMetier {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	private User user = null ;
	
	@Override
	public User addUser(Register register) {
		
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String encodedPassword = encoder.encode(register.getPassword());
			register.setPassword(encodedPassword);
			
			
			Set<String> rolesInRegister = register.getRoles();
			Set<Role> roles = new HashSet<Role>();
			
			
				roles.add(roleRepository.findByName("CLIENT"));
				user = new Client();
			
				rolesInRegister.forEach(role ->{
					switch(role) {
						case "EMPLOYE" :
								roles.add(roleRepository.findByName("EMPLOYE"));
								user = new Employe();
								break;
						case "ADMIN" :
								roles.add(roleRepository.findByName("ADMIN"));
								user = new Employe();
								break;
						default : // every single user should have Client role by default
								roles.add(roleRepository.findByName("CLIENT"));
								user = new Client();
								break;
					}
				});
			
			user.setUsername(register.getUsername());
			user.setEmail(register.getEmail());
			user.setPassword(register.getPassword());
			user.setRoles(roles);
			
	        return userRepository.save(user);
			
		}catch(Exception e) {
			System.out.println("Could not register User! ");
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
	    	user = userRepository.findByUsername(username);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		    
	  return user;
			
	}

	@Override
	public User updateUser(User user) {
		try {
			// ynajmou y8ouchna na3ref ama mouch wa9tou tw :/
			
			return userRepository.save(user);
			
		}catch(Exception e) {
			System.out.println("Could not add this User! ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
}
