package chmin9lewis.Restaurants.feane;

import java.util.List;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import chmin9lewis.Restaurants.feane.Entity.Employe;
import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.Image;
import chmin9lewis.Restaurants.feane.Entity.Restaurant;
import chmin9lewis.Restaurants.feane.Entity.Role;
import chmin9lewis.Restaurants.feane.Entity.ThirdParty;
import chmin9lewis.Restaurants.feane.Entity.User;
import chmin9lewis.Restaurants.feane.Metier.IImageMetier;
import chmin9lewis.Restaurants.feane.Metier.IRestaurantMetier;
import chmin9lewis.Restaurants.feane.Metier.IRoleMetier;
import chmin9lewis.Restaurants.feane.Metier.IUserMetier;
import chmin9lewis.Restaurants.feane.Repository.UserRepository;



@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FeaneApplication implements CommandLineRunner{

	@Autowired
	IRoleMetier roleMetier;
	
	@Autowired
	IUserMetier userMetier;
	
	@Autowired
	IRestaurantMetier restaurantMetier;
	
	@Autowired
	IImageMetier imageMetier;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(FeaneApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedHeaders("*").allowedOrigins("http://localhost:4200").allowedMethods("*")
				.allowCredentials(true);
			}
		};
	}
	
	@Bean
    public ServletWebServerFactory servletContainer() {
        // Enable SSL Trafic
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };

        // Add HTTP to HTTPS redirect
        tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());

        return tomcat;
    }

    /*
    We need to redirect from HTTP to HTTPS. Without SSL, this application used
    port 8080. With SSL it will use port 8079. So, any request for 8080 needs to be
    redirected to HTTPS on 8079.
     */
    private Connector httpToHttpsRedirectConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8079);
        return connector;
    }
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		//Create encoder so we can hash the password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//Creatin admin role
		Role adminRole = new Role();
		//Initializin admin role
			adminRole.setName("ADMIN");
		//Adding admin role into Data Base
		roleMetier.addRole(adminRole);
		
		//Creatin employe role
		Role employeRole = new Role();
			//Initializin employe role
		employeRole.setName("EMPLOYE");
		//Adding employe role into Data Base
		roleMetier.addRole(employeRole);
		
		//Creatin thirdParty role
		Role thirdPartyRole = new Role();
			//Initializin thirdParty role
		thirdPartyRole.setName("THIRD_PARTY");
		//Adding thirdParty role into Data Base
		roleMetier.addRole(thirdPartyRole);
		
		//Creatin admin User
		User admin = new Employe();
			//Initializin admin User
			admin.setNom("Karbich");
			admin.setPrenom("Firas");
			admin.setUserName("zed");
			admin.setPassword(encoder.encode("12345"));
			//Adding this admin user to the adminRole's users List
			adminRole.getUsers().add(admin);
		//Adding this admin user into Data Base
		userMetier.addUser(admin);
		//Adding adminRole to this admin user Role's List
		admin.getRoles().add(adminRole);
		//Updating admin Role
		roleMetier.updateRole(adminRole);
		
		//Creatin employe  User
		User user = new Employe();
			//Initializin employe
			user.setNom("Essaied");
			user.setPrenom("Iheb");
			user.setUserName("loco");
			user.setPassword(encoder.encode("12345"));
			//Adding this employe to the employeRole's users List
			employeRole.getUsers().add(user);
		//Adding this employe into Data Base
		userMetier.addUser(user);
		//Adding employeRole to this employe Role's List
		user.getRoles().add(employeRole);
		//Updating employe Role
		roleMetier.updateRole(employeRole);
		
		//Creatin thirdParty User
			User thirdPartyUser = new ThirdParty();
			//Initializin thirdParty User
			thirdPartyUser.setNom("nom ta3 moula thirdParty fil denya");
			thirdPartyUser.setPrenom("prenom ta3 moula thirdParty fil denya");
			thirdPartyUser.setUserName("Wakalni");
			thirdPartyUser.setPassword(encoder.encode("12345"));
			//Adding this thirdParty user to the thirdPartyRole's users List
			thirdPartyRole.getUsers().add(thirdPartyUser);
		//Adding this thirdParty user into Data Base
		userMetier.addUser(thirdPartyUser);
		//Adding thirdPartyRole to this thirdParty user Role's List
		thirdPartyUser.getRoles().add(thirdPartyRole);
		//Updating thirdParty Role
		roleMetier.updateRole(thirdPartyRole);
		
		//Creatin restaurant Object
		Restaurant feane = new Restaurant();
			//Initializin Restaurant
			feane.setName("Feane");	
			feane.setEmail("feane@gmail.com");
			feane.setAdresse("Quai Khemais Ternane Vieux port Bizerte, 7000");
			//Creatin Image object for this restaurant
				Image image = new Image("images/modern-restaurant-menu-for-fast-food/4520928.jpg", "images/Fast_food_Hamburger_Vegetables_Fire_Two_520128_1920x1080.jpg", "images/feane_profile_picture.jpg",true);
				//Adding this image into Data Base
				imageMetier.addImage(image);
			feane.setImage(image);
		//Adding this restaurant into Data Base
		restaurantMetier.addRestaurant(feane);
		//Updating image
		image.setRestaurant(feane);
		imageMetier.updateImage(image);
		
		
		//Creating food List
		
		*/
		
	}

}
