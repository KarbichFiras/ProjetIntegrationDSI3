package chmin9lewis.project.wakelni;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import chmin9lewis.project.wakelni.Repository.UserRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WakelniApplication implements CommandLineRunner{

	// 20 days token with role thirdParty used to connect with fean's APIs : 
	//Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJXYWthbG5pIiwiZXhwIjoxNjQyMjAzNTA5fQ.jciupFBD_F4sHq246rXSqaLI3MCSJ1zQpF_XdXwBrjuDuM551dQW1CBxMZdsAxd2tUHazXQHdPCdsvaox1praQ
	
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
		        .baseUrl("https://localhost:8079")
		        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		        .build();
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
