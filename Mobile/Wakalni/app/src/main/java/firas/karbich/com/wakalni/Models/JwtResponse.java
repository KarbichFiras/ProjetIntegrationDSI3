package firas.karbich.com.wakalni.Models;

import java.util.ArrayList;
import java.util.Collection;

public class JwtResponse {

    private String jwt;
    private String username;
    private Collection<String> authorities = new ArrayList<String>();

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

    public Collection<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<String> authorities) {
        this.authorities = authorities;
    }
}
