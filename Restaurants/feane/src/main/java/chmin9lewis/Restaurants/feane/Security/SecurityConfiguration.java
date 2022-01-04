package chmin9lewis.Restaurants.feane.Security;

import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
	
	// Used by spring security if CORS is enabled.
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		try {
			// Enable CORS and disable CSRF
	        http = http.cors().and().csrf().disable();
	        
	        // Set session management to stateless
	        http = http
	            .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and();
	        
	        // Set unauthorized requests exception handler
	        http = http
	            .exceptionHandling()
	            .authenticationEntryPoint(
	                (request, response, ex) -> {
	                    response.sendError(
	                        HttpServletResponse.SC_UNAUTHORIZED,
	                        ex.getMessage()
	                    );
	                }
	            )
	            .and();
			// add jwt filters (1. authentication, 2. authorization)
            http.addFilter(new JwtAuthenticationFilter(authenticationManager()))
	            .addFilter(new JwtAuthorizationFilter(authenticationManager(),  userRepository));
			http.authorizeRequests()
				//.antMatchers(HttpMethod.GET, "/").permitAll()
				//.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.GET, "/getAllUsers").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/restaurants/getAllRestaurants").permitAll()
				.antMatchers(HttpMethod.GET, "/getSpecificRestaurant").permitAll()
				.antMatchers(HttpMethod.GET, "/getRestaurantByFood").permitAll()
				.antMatchers(HttpMethod.GET, "/getFooddeatildByRestaurant").permitAll()
			
		
			;
			
			
		}catch(Exception e) {
			System.out.println("die :"+e.getMessage());
		}
	}
}
