package chmin9lewis.Restaurants.feane;

import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import chmin9lewis.Restaurants.feane.Entity.Categorie;
import chmin9lewis.Restaurants.feane.Entity.Employe;
import chmin9lewis.Restaurants.feane.Entity.Extras;
import chmin9lewis.Restaurants.feane.Entity.Food;
import chmin9lewis.Restaurants.feane.Entity.FoodWithExtras;
import chmin9lewis.Restaurants.feane.Entity.Image;
import chmin9lewis.Restaurants.feane.Entity.Menu;
import chmin9lewis.Restaurants.feane.Entity.Restaurant;
import chmin9lewis.Restaurants.feane.Entity.Role;
import chmin9lewis.Restaurants.feane.Entity.ThirdParty;
import chmin9lewis.Restaurants.feane.Entity.User;
import chmin9lewis.Restaurants.feane.Metier.FoodMetier;
import chmin9lewis.Restaurants.feane.Metier.ICategorieMetier;
import chmin9lewis.Restaurants.feane.Metier.IExtrasMetier;
import chmin9lewis.Restaurants.feane.Metier.IFoodMetier;
import chmin9lewis.Restaurants.feane.Metier.IFoodWithExtrasMetier;
import chmin9lewis.Restaurants.feane.Metier.IImageMetier;
import chmin9lewis.Restaurants.feane.Metier.IMenuMetier;
import chmin9lewis.Restaurants.feane.Metier.IRestaurantMetier;
import chmin9lewis.Restaurants.feane.Metier.IRoleMetier;
import chmin9lewis.Restaurants.feane.Metier.IUserMetier;
import chmin9lewis.Restaurants.feane.Repository.FoodRepository;
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
	
	@Autowired
	ICategorieMetier categorieMetier;
	
	@Autowired
	IExtrasMetier extrasMetier;
	
	@Autowired
	IFoodMetier foodMetier;
	
	@Autowired
	IMenuMetier menuMetier;
	
	@Autowired
	IFoodWithExtrasMetier foodWithExtrasMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(FeaneApplication.class, args);
	}
	
	@Bean
	public WebClient getWebClient(){
		
		return WebClient.builder()
		        .baseUrl("http://localhost:8080")
		        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		        .build();
	}
	
	/*@Bean
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
    }*/

    /*
    We need to redirect from HTTP to HTTPS. Without SSL, this application used
    port 8080. With SSL it will use port 8079. So, any request for 8080 needs to be
    redirected to HTTPS on 8079.
     */
 /*   private Connector httpToHttpsRedirectConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8079);
        return connector;
    }*/
	
	@Override
	public void run(String... args) throws Exception {
		
	/*
		String password ="12345";
		
		//Creatin admin role
		Role adminRole = new Role();
		//Initializin admin role
			adminRole.setName("ADMIN");
		//Adding admin role into Data Base
		adminRole = roleMetier.addRole(adminRole);
		
		//Creatin employe role
		Role employeRole = new Role();
			//Initializin employe role
		employeRole.setName("EMPLOYE");
		//Adding employe role into Data Base
		employeRole = roleMetier.addRole(employeRole);
		
		//Creatin client role
		Role clientRole = new Role();
			//Initializin client role
			clientRole.setName("CLIENT");
		//Adding client role into Data Base
		clientRole = roleMetier.addRole(clientRole);
		
		//Creatin thirdParty role
		Role thirdPartyRole = new Role();
			//Initializin thirdParty role
		thirdPartyRole.setName("THIRD_PARTY");
		//Adding thirdParty role into Data Base
		thirdPartyRole = roleMetier.addRole(thirdPartyRole);
		
		//Creatin admin User
		User admin = new Employe();
			//Initializin admin User
			admin.setNom("Karbich");
			admin.setPrenom("Firas");
			admin.setUserName("zed");
			admin.setPassword(password);
			//Adding this admin user to the adminRole's users List
			adminRole.getUsers().add(admin);
		//Adding this admin user into Data Base
		admin = userMetier.addUser(admin);
		//Adding adminRole to this admin user Role's List
		admin.getRoles().add(adminRole);
		//Updating admin Role
		adminRole = roleMetier.updateRole(adminRole);
		
		//Creatin employe  User
		User user = new Employe();
			//Initializin employe
			user.setNom("Essaied");
			user.setPrenom("Iheb");
			user.setUserName("loco");
			user.setPassword(password);
			//Adding this employe to the employeRole's users List
			employeRole.getUsers().add(user);
		//Adding this employe into Data Base
		user = userMetier.addUser(user);
		//Adding employeRole to this employe Role's List
		user.getRoles().add(employeRole);
		//Updating employe Role
		employeRole = roleMetier.updateRole(employeRole);
		
		//Creatin thirdParty User
			User thirdPartyUser = new ThirdParty();
			//Initializin thirdParty User
			thirdPartyUser.setNom("nom ta3 moula thirdParty fil denya");
			thirdPartyUser.setPrenom("prenom ta3 moula thirdParty fil denya");
			thirdPartyUser.setUserName("Wakalni");
			thirdPartyUser.setPassword(password);
			//Adding this thirdParty user to the thirdPartyRole's users List
			thirdPartyRole.getUsers().add(thirdPartyUser);
		//Adding this thirdParty user into Data Base
		thirdPartyUser = userMetier.addUser(thirdPartyUser);
		//Adding thirdPartyRole to this thirdParty user Role's List
		thirdPartyUser.getRoles().add(thirdPartyRole);
		//Updating thirdParty Role
		thirdPartyRole = roleMetier.updateRole(thirdPartyRole);

		//Creating Categorie
		Categorie sandwitch = new Categorie();
			sandwitch.setName("Sandwitch");
			sandwitch = categorieMetier.addCategorie(sandwitch);
		Categorie plate = new Categorie();
			plate.setName("Plate");
			plate = categorieMetier.addCategorie(plate);
			
			//Creating extras
			Extras bsal = new Extras();
				bsal.setName("Bsal");
				bsal.setPrixUnitaire(100);//100 frank
				bsal = extrasMetier.addExtras(bsal);
			Extras mayonnaise = new Extras();
				mayonnaise.setName("Mayonnaise");
				mayonnaise.setPrixUnitaire(200);//100 frank	
				mayonnaise = extrasMetier.addExtras(mayonnaise);
			Extras salami = new Extras();
				salami.setName("Salami");
				salami.setPrixUnitaire(150);//100 frank	
				salami = extrasMetier.addExtras(salami);
				
		// Declarations
		Restaurant feane;
		Image image;
		Food food;
		Menu menu;
		FoodWithExtras foodWithExtras;
		Collection<FoodWithExtras> produitFinalList = new ArrayList<FoodWithExtras>();
		List<FoodWithExtras> listFoodWithExtras = new ArrayList<FoodWithExtras>();
		String[] foodsLibelles = {"Mlaoui", "Lablebi", "Sa7fa Lablebi", "3ijja", "Ma9rouna", "Salade", "Koskssi", "S7an Tounsi", "Ma9loub", "Rokba"};
		int k = 0;
		
		for( int j = 1 ; j < 11; j ++) {
			food = new Food();
			food.setCategorie(sandwitch);
			food.setLibelle(foodsLibelles[j-1]);
			food.setPrix((1000 * j) );
			food.setImage("image here");
			food = foodMetier.addFood(food);
		}
		
		for(int i = 1 ; i< 11 ; i++) {
			
			//Creatin restaurant Object
			feane = new Restaurant();
				//Initializin Restaurant
				feane.setName("Feane" + i);	
				feane.setEmail("feane"+ i +"@gmail.com");
				feane.setAdresse("Quai Khemais Ternane Vieux port Bizerte, 7000");
				feane.setDescription("Mekletna bnina barcha , wndifa juste titsamim wkhw order now fech testana");
					if(i % 3 == 0) { 
						feane.setEnabled(false);
					}
				//Creatin Image object for this restaurant
					image = new Image("images/modern-restaurant-menu-for-fast-food/4520928.jpg", "images/Fast_food_Hamburger_Vegetables_Fire_Two_520128_1920x1080.jpg", "images/feane_profile_picture.jpg",true);
					//Adding this image into Data Base
					image = imageMetier.addImage(image);
				feane.setImage(image);
				//Adding this restaurant into Data Base
				feane = restaurantMetier.addRestaurant(feane);
				
				menu = new Menu();
				menu.setTitre("WeekEnd"+i+" Menu");
				menu.setRestaurant(feane);
					
				
				menu.setMenuFoods(listFoodWithExtras);
				menu = menuMetier.addMenu(menu);
				
				for( int j = 0 ; j < 3; j ++) {
					
					if(k == foodsLibelles.length) { k=0; }
						
						food = foodMetier.getFoodByLibelle(foodsLibelles[k]);
					
						foodWithExtras = new FoodWithExtras();
						// t3abii ka3ba FoodWithExtras wtsobha fil base
							//combo hayka bil extras kol we7id w9asmou :p
							if( k % 1 == 0 ) {
								foodWithExtras.setExtras(bsal);
							}else{
								foodWithExtras.setExtras(salami);
							}
							
							if( k % 2 == 0) {
								foodWithExtras.setExtras(mayonnaise);
							}
						
						foodWithExtras.setFood(food);
						foodWithExtras = foodWithExtrasMetier.addFoodWithExtras(foodWithExtras);
							// bch tasne3 list bch t7ot fiha barcha ka3bet FoodWithExtras
							listFoodWithExtras = new ArrayList<FoodWithExtras>();
							listFoodWithExtras.add(foodWithExtras);
							//kol extras w food mawjoudin fi kol ka3ba FoodWithExtras lezim tzidhom ilist wta3mlilhom update filDB
							//combo hayka bil extras kol we7id w9asmou :p
							if( k % 1 == 0 ) {
								bsal.setFoodWithExtras(listFoodWithExtras);
								bsal = extrasMetier.updateExtras(bsal);
							}else{
								salami.setFoodWithExtras(listFoodWithExtras);
								salami = extrasMetier.updateExtras(salami);
							}
							
							if( k % 2 == 0) {
								mayonnaise.setFoodWithExtras(listFoodWithExtras);
								mayonnaise = extrasMetier.updateExtras(mayonnaise);
							}
							
							
							food.setFoodWithExtras(listFoodWithExtras);
							food = foodMetier.updateFood(food);
							
							
						foodWithExtras.setMenu(menu);
						foodWithExtras = foodWithExtrasMetier.updateFoodWithExtras(foodWithExtras);
							
						k++;	
				}
		}
		*/
	}

}

