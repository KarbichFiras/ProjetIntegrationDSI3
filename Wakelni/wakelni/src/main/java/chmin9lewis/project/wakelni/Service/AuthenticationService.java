package chmin9lewis.project.wakelni.Service;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.project.wakelni.Metier.IUserMetier;
import chmin9lewis.project.wakelni.Models.LoginViewModel;
import chmin9lewis.project.wakelni.Models.Register;
import chmin9lewis.project.wakelni.Models.ResponseMessage;
import chmin9lewis.project.wakelni.Security.JwtProvider;
import chmin9lewis.project.wakelni.Security.JwtResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthenticationService {

	@Autowired
	IUserMetier userMetier;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@RequestMapping(value="/register" , method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> registerUser(@Valid @RequestBody Register register){
		
		// checking the username 
		if(userMetier.existsByUsername(register.getUsername())) {
			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Username is already taken !"), HttpStatus.BAD_REQUEST);
		}
		
		// checking the email
		if(userMetier.existsByEmail(register.getEmail())) {
			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Email is already in use !"), HttpStatus.BAD_REQUEST);
		}
		
		// Virgin register so
		// register the user
		if(userMetier.addUser(register) != null ) {
			return new ResponseEntity<>(new ResponseMessage("User Registred succesfully !"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseMessage("Could Not Registre You !"), HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@Valid @RequestBody LoginViewModel credentials){
		
		
		Authentication authentication = authenticationManager.authenticate(
																new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword())
																);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
		JwtResponse jwtResponse = new JwtResponse(jwt,userPrincipal.getUsername(),userPrincipal.getAuthorities());
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	

	
	
}
