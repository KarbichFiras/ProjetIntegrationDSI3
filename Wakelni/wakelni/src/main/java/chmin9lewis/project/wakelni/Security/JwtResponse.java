package chmin9lewis.project.wakelni.Security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {

	private String jwt;
	private String username;
	Collection<? extends GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	
	public JwtResponse() {
		super();
	}

	public JwtResponse(String jwt, String username, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.jwt = jwt;
		this.username = username;
		this.authorities = authorities;
	}
	
	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
