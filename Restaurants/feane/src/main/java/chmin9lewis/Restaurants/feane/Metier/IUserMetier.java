package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.User;

public interface IUserMetier {

	public User getUserDetails(Long userId);
	public List<User> getAllUsers();
	public User addUser(User user);
	public User updateUser(User user);
	public boolean deleteUser(User user);
	public boolean deleteUserById(Long userId);
	public boolean enableUser(Long userId);
	public boolean desableUser(Long userId);
	
}
