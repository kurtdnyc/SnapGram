package dev.snapgram.repositorytests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import dev.snapgram.entities.User;
import dev.snapgram.repositories.UserRepository;
import dev.snapgram.app.SnapGramSpringApplication;

@SpringBootTest(classes = SnapGramSpringApplication.class)
@Transactional
@TestMethodOrder(OrderAnnotation.class) 
public class UserRepositoryTests {

	
	@Autowired
	UserRepository ur;
	
	@Test
	@Order(1)
	void findByUsername() {
		User user1 = new User(0, "user1", "password1", "first1", "last1");
		User user2 = new User(0, "user2", "password2", "first2", "last2");
		User user3 = new User(0, "user3", "password3", "first3", "last3");
		ur.save(user1);
		ur.save(user2);
		ur.save(user3);
		
		User testuser = ur.findByUsername("user2");
		Assertions.assertEquals("user2", testuser.getUsername());
	}
	
	@Test
	@Order(2)
	void findByUsernameAndPassword() {
		User user1 = new User(0, "user1", "password1", "first1", "last1");
		User user2 = new User(0, "user2", "password2", "first2", "last2");
		User user3 = new User(0, "user3", "password3", "first3", "last3");
		ur.save(user1);
		ur.save(user2);
		ur.save(user3);
		
		User testuser = ur.findByUsernameAndPassword("user3", "password3");
		Assertions.assertEquals("user3", testuser.getUsername());
	}

}
