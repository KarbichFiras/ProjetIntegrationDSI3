package chmin9lewis.Restaurants.feane.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import chmin9lewis.Restaurants.feane.Repository.UserRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	UserRepository userRepository;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		try {
			authProvider.setPasswordEncoder(passwordEncoder());
			authProvider.setUserDetailsService(userDetailsServiceImpl);
		}catch(Exception e) {
			System.out.println("die :"+e.getMessage());
		}
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		try {
			auth.authenticationProvider(authenticationProvider());
		}catch(Exception e) {
			System.out.println("die :"+e.getMessage());
		}
	}
	
	/*@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	        .antMatchers("/login", "/logout");
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http
			// remove csrf and state in session because in jwt we do not need them
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			// add jwt filters (1. authentication, 2. authorization)
            .addFilter(new JwtAuthenticationFilter(authenticationManager()))
            .addFilter(new JwtAuthorizationFilter(authenticationManager(),  userRepository))
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/").permitAll()
			//.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers(HttpMethod.GET, "/getAllUsers").permitAll()
			.antMatchers(HttpMethod.GET, "/getAllRestaurants").permitAll()
			.antMatchers(HttpMethod.GET, "/getSpecificRestaurant").permitAll()
			.antMatchers(HttpMethod.GET, "/getRestaurantByFood").permitAll()
			.anyRequest().permitAll();
			;
			
			
		}catch(Exception e) {
			System.out.println("die :"+e.getMessage());
		}
	}
}
