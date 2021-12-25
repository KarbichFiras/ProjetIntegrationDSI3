package chmin9lewis.Restaurants.feane.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chmin9lewis.Restaurants.feane.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String UserName);
	
}
