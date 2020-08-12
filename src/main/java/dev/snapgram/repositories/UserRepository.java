package dev.snapgram.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.snapgram.entities.User;

@Component
@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
}
