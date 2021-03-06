package chmin9lewis.project.wakelni.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import chmin9lewis.project.wakelni.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public	User findByUsername(String UserName);
	
	public boolean existsByUsername(String username);

	public boolean existsByEmail(String email);
	
}
