package chmin9lewis.Restaurants.feane.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chmin9lewis.Restaurants.feane.Entity.Role;
import chmin9lewis.Restaurants.feane.Metier.IRoleMetier;

@RestController
public class RoleService {

	@Autowired
	IRoleMetier roleMetier;
	
	@RequestMapping(value="/getRoleDetails/{code}", method=RequestMethod.GET)
	public Role getRoleDetails(@PathVariable(name="code") Long roleId) {
		return roleMetier.getRoleDetails(roleId);
	}
	@RequestMapping(value="/getAllRole", method=RequestMethod.GET)
	public List<Role> getAllRole() {
		return roleMetier.getAllRole();
	}

	@RequestMapping(value="/addRole", method=RequestMethod.POST)
	public Role addRole(@RequestBody Role role) {
		return roleMetier.addRole(role);
	}

	@RequestMapping(value="/updateRole", method=RequestMethod.PUT)
	public Role updateRole(@RequestBody Role role) {
		return roleMetier.updateRole(role);
	}

	@RequestMapping(value="/deleteRole", method=RequestMethod.DELETE)
	public boolean deleteRole(@RequestBody Role role) {
		return roleMetier.deleteRole(role);
	}

	@RequestMapping(value="/deleteRoleById/{code}", method=RequestMethod.DELETE)
	public boolean deleteRoleById(@PathVariable(name="code") Long roleId) {
		return roleMetier.deleteRoleById(roleId);
	}
	
	@RequestMapping(value="/enableRole/{code}", method=RequestMethod.PUT)
	public boolean enableRole(@PathVariable(name="code") Long roleId) {
		return roleMetier.enableRole(roleId);
	}

	@RequestMapping(value="/desableRole/{code}", method=RequestMethod.PUT)
	public boolean desableRole(@PathVariable(name="code") Long roleId) {
		return roleMetier.desableRole(roleId);
	}

}
