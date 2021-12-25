package chmin9lewis.Restaurants.feane.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.User;
import chmin9lewis.Restaurants.feane.Repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(username);
	
		if(user == null ) {
			throw new UsernameNotFoundException("Could not find user : " +username);
		}
		
		MyUserDetails myUserDetails = new MyUserDetails(user);
		
		return myUserDetails;
	}

}
