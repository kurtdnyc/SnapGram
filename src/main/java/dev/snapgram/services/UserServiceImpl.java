package dev.snapgram.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.snapgram.entities.User;
import dev.snapgram.exceptions.InvalidLoginException;
import dev.snapgram.repositories.UserRepository;
import dev.snapgram.repositories.UserDAOSpring;

@Component
@Service
public class UserServiceImpl implements UserService {

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
		// how
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// how
		return null;
	}

}
