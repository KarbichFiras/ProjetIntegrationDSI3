package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.User;
import chmin9lewis.Restaurants.feane.Metier.IUserMetier;

@RestController
@CrossOrigin
public class UserService {

	@Autowired
	IUserMetier userMetier;
	
	@RequestMapping(value="/getUserDetails/{id}" , method = RequestMethod.GET)
	public User getUserDetails(@PathVariable(name="id") Long userId) {
		return userMetier.getUserDetails(userId);
	}

	@RequestMapping(value="/getAllUsers" , method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userMetier.getAllUsers();
	}

	@RequestMapping(value="/addUser" , method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		return userMetier.addUser(user);
	}

	@RequestMapping(value="/updateUser" , method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return userMetier.updateUser(user);
	}

	@RequestMapping(value="/deleteUser" , method = RequestMethod.DELETE)
	public boolean deleteUser(@RequestBody User user) {
		return userMetier.deleteUser(user);
	}

	@RequestMapping(value="/deleteUserById/{id}" , method = RequestMethod.DELETE)
	public boolean deleteUserById(@PathVariable(name="id") Long userId) {
		return userMetier.deleteUserById(userId);
	}

	@RequestMapping(value="/enableUser/{id}" , method = RequestMethod.PUT)
	public boolean enableUser(@PathVariable(name="id") Long userId) {
		return userMetier.enableUser(userId);
	}

	@RequestMapping(value="/desableUser/{id}" , method = RequestMethod.PUT)
	public boolean desableUser(@PathVariable(name="id") Long userId) {
		return userMetier.desableUser(userId);
	}

}
