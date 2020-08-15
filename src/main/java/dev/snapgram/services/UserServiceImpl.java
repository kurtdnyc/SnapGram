package dev.snapgram.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.snapgram.entities.User;
import dev.snapgram.exceptions.InvalidLoginException;
import dev.snapgram.repositories.UserRepository;
import net.bytebuddy.asm.Advice.This;


@Component
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository ur;
	
	
	public UserServiceImpl(UserRepository ur) {
		super();
		this.ur=ur;
	}
	
	@Override
	public User createUser(User user) {
		return this.ur.save(user);
	}

	@Override
	public User getUserById(int id) {
		return this.ur.findById(id).get();
	}

	@Override
	public User getUserByLogin(String username, String password) throws InvalidLoginException {
		return this.ur.findByUsernameAndPassword(username, password);
	}

	@Override
	public User getUserByUsername(String username) {
		return this.ur.findByUsername(username);
	}

}
