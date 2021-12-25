package chmin9lewis.project.wakelni.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chmin9lewis.project.wakelni.Entity.Client;
import chmin9lewis.project.wakelni.Entity.Role;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
