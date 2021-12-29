package chmin9lewis.project.wakelni.Security;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import chmin9lewis.project.wakelni.Repository.UserRepository;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	// bch tnajem tasne3 instance min AuthenticationManager so u can use it where ever u want 
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
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
				.antMatchers("/api/auth/**").permitAll()
				.antMatchers("/api/restaurants/**").hasAuthority("ADMIN")
				.antMatchers("/addUser").hasAuthority("ADMIN")
				.antMatchers("/addRole").hasAuthority("ADMIN")
				.antMatchers("/consultFacture").authenticated()
				.antMatchers("/newOrder").hasAuthority("ADMIN")
				;
			
		}catch(Exception e) {
			System.out.println("die :"+e.getMessage());
		}
	}

}
