package chmin9lewis.project.wakelni.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chmin9lewis.project.wakelni.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByName(String name); 
}
