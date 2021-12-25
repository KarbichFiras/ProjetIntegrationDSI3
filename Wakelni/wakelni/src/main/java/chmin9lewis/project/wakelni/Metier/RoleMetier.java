package chmin9lewis.project.wakelni.Metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.project.wakelni.Entity.Role;
import chmin9lewis.project.wakelni.Repository.RoleRepository;

@Service
public class RoleMetier implements IRoleMetier{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role addRole(Role role) {
		
		return roleRepository.save(role);
	}

}
