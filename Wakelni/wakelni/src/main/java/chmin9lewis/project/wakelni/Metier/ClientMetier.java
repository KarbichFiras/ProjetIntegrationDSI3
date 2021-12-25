package chmin9lewis.project.wakelni.Metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import chmin9lewis.project.wakelni.Entity.Client;
import chmin9lewis.project.wakelni.Entity.Role;
import chmin9lewis.project.wakelni.Entity.User;
import chmin9lewis.project.wakelni.Repository.ClientRepository;
import chmin9lewis.project.wakelni.Repository.RoleRepository;
import chmin9lewis.project.wakelni.Repository.UserRepository;



@Service
public class ClientMetier implements IClientMetier {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	RoleRepository roleRepository;
	


	@Override
	public Client addClient(Client client) {
		try {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String encodedPassword = encoder.encode(client.getPassword());
			client.setPassword(encodedPassword);
			Role role = roleRepository.findByName("USER");
			client.getRoles().add(role);
			return clientRepository.save(client);
		}catch(Exception e) {
			System.out.println("Could not add this User! ");
			e.printStackTrace();
			return null;
		}
	}

	
}
