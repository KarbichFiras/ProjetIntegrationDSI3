package chmin9lewis.project.wakelni.Metier;

import chmin9lewis.project.wakelni.Entity.User;

public interface IUserMetier {
	public User addUser(User user);

	public User getLoggedUser();
}
