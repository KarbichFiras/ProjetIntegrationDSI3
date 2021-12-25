package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chmin9lewis.Restaurants.feane.Entity.Role;
import chmin9lewis.Restaurants.feane.Repository.RoleRepository;

@Service
public class RoleMetier implements IRoleMetier{

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role getRoleDetails(Long roleId) {
		try {
			return roleRepository.findById(roleId).get();
		}catch(Exception e) {
			System.out.println("Could not find any role with this id : " + roleId);
			return null;
		}
	}

	@Override
	public List<Role> getAllRole() {
		try {
			return roleRepository.findAll();
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Role addRole(Role role) {		
		try {
			return roleRepository.save(role);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public Role updateRole(Role role) {
		try {
			return roleRepository.save(role);
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return null;
		}
	}

	@Override
	public boolean deleteRole(Role role) {
		try {
			roleRepository.delete(role);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean deleteRoleById(Long roleId) {
		try {
			roleRepository.deleteById(roleId);
			return true;
		}catch(Exception e) {
			System.out.println("Could not execute this Operation! ");
			return false;
		}
	}

	@Override
	public boolean enableRole(Long roleId) {
		try {
			Role role = roleRepository.findById(roleId).get();
			role.setEnabled(true);
			updateRole(role);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any role with this id : " + roleId);
			return false;
		}
	}

	@Override
	public boolean desableRole(Long roleId) {
		try {
			Role role = roleRepository.findById(roleId).get();
			role.setEnabled(false);
			updateRole(role);
			return true;
		}catch(Exception e) {
			System.out.println("Could not find any role with this id : " + roleId);
			return false;
		}
	}
	
	
	
}
