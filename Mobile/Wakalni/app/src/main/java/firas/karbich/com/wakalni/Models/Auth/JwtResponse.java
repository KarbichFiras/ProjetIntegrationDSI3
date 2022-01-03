package firas.karbich.com.wakalni.Models.Auth;

import java.util.ArrayList;
import java.util.Collection;

public class JwtResponse {

    private String jwt;
    private String username;
    private Collection<?> authorities = new ArrayList<>();

    public JwtResponse() {
    }

    public JwtResponse(String jwt, String username, Collection<String> roles) {
        this.jwt = jwt;
        this.username = username;
        this.authorities = roles;
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

    public Collection<?> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<?> authorities) {
        this.authorities = authorities;
    }
}
