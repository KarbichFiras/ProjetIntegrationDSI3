package firas.karbich.com.wakalni.Models;

import java.util.ArrayList;
import java.util.Collection;

public class LoginResponse {

    private String jwt;
    private String username;
    private Collection<String> roles = new ArrayList<String>();

    public LoginResponse() {
    }

    public LoginResponse(String jwt, String username, Collection<String> roles) {
        this.jwt = jwt;
        this.username = username;
        this.roles = roles;
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

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }
}
