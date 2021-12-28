package chmin9lewis.project.wakelni.Metier;

import chmin9lewis.project.wakelni.Entity.Role;

public interface IRoleMetier {
	public Role addRole(Role role);
	public Role updateRole(Role role);
	public Role getRoleByName(String roleName);
}
