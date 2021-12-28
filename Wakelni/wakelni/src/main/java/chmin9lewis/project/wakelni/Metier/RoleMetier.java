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
		try {
			return roleRepository.save(role);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Role updateRole(Role role) {
		try {
			return roleRepository.save(role);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Role getRoleByName(String roleName) {
		try {
			return roleRepository.findByName(roleName);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
