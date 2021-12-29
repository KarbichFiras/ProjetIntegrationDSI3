package chmin9lewis.project.wakelni.Metier;

import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Models.Register;

public interface IUserMetier {
	
	public User addUser(Register user);
	public User updateUser(User user);
	public User getLoggedUser();
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
}
