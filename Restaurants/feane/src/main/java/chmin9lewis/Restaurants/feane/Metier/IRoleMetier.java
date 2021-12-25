package chmin9lewis.Restaurants.feane.Metier;

import java.util.List;

import chmin9lewis.Restaurants.feane.Entity.Role;

public interface IRoleMetier {

	public Role getRoleDetails(Long roleId);
	public List<Role> getAllRole();
	public Role addRole(Role role);
	public Role updateRole(Role role);
	public boolean deleteRole(Role role);
	public boolean deleteRoleById(Long roleId);
	public boolean enableRole(Long roleId);
	public boolean desableRole(Long roleId);
	
}
