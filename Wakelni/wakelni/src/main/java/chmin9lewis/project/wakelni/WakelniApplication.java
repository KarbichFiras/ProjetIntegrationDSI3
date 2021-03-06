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
import chmin9lewis.project.wakelni.Models.Register;
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
	public WebClient getWebClient(){
		
		return WebClient.builder()
		        .baseUrl("http://localhost:8080")
		        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		        .build();
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*
		String password ="12345";
			
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
			
			*/
		
	}
}
