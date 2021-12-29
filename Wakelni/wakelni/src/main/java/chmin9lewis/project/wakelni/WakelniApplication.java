package chmin9lewis.project.wakelni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import chmin9lewis.project.wakelni.Entity.Employe;
import chmin9lewis.project.wakelni.Entity.Role;
import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Metier.IRoleMetier;
import chmin9lewis.project.wakelni.Metier.IUserMetier;
import chmin9lewis.project.wakelni.Repository.UserRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WakelniApplication implements CommandLineRunner{

	// 20 days token with role thirdParty used to connect with fean's APIs : 
	//Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJXYWthbG5pIiwiZXhwIjoxNjQyMjAzNTA5fQ.jciupFBD_F4sHq246rXSqaLI3MCSJ1zQpF_XdXwBrjuDuM551dQW1CBxMZdsAxd2tUHazXQHdPCdsvaox1praQ
	
	@Autowired
	IRoleMetier roleMetier;
	
	@Autowired
	IUserMetier userMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(WakelniApplication.class, args);
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
	public WebClient getWebClient(){
		
		return WebClient.builder()
		        .baseUrl("http://localhost:8080")
		        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		        .build();
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		/*String password ="12345";
		
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
		
		//Creatin client role
		Role clientRole = new Role();
			//Initializin client role
			clientRole.setName("CLIENT");
		//Adding client role into Data Base
		roleMetier.addRole(clientRole);
		
		//Creatin admin User
		User admin = new Employe();
			//Initializin admin User
			admin.setNom("Karbich");
			admin.setPrenom("Firas");
			admin.setUsername("zed");
			admin.setAdresse("Bizerte");
			admin.setTel("50262899");
			admin.setEmail("firasKarbich@gmail.com");
			admin.setPassword(password);
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
			user.setUsername("loco");
			user.setPassword(password);
			user.setAdresse("Bizerte");
			user.setTel("32145698");
			user.setEmail("loco@gmail.com");
			//Adding this employe to the employeRole's users List
			employeRole.getUsers().add(user);
		//Adding this employe into Data Base
		userMetier.addUser(user);
		//Adding employeRole to this employe Role's List
		user.getRoles().add(employeRole);
		//Updating employe Role
		roleMetier.updateRole(employeRole);
		
	*/
}
}
