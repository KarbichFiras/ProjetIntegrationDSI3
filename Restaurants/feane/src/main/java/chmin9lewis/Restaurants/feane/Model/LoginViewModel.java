package chmin9lewis.Restaurants.feane.Model;

public class LoginViewModel {

	private String username;
    private String password;
    
	public LoginViewModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public LoginViewModel() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
