package dev.snapgram.services;

import dev.snapgram.beans.User;
import dev.snapgram.daos.UserDAO;
import dev.snapgram.daos.UserDAOSpring;

public class UserServiceImpl implements UserService {

	private UserDAO udao;
	
	
	public UserServiceImpl() {
		super();
		this.udao = new UserDAOSpring();
	}
	
	public UserServiceImpl(UserDAO udao) {
		super();
		this.udao=udao;
	}
	
	@Override
	public User createUser(User user) {
		return this.udao.createUser(user);
	}

	@Override
	public User getUserById(int id) {
		return this.udao.getUserById(id);
	}

	@Override
	public User getUserByLogin(String username, String password) {
		return this.udao.getUserByLogin(username, password);
	}

	@Override
	public User getUserByUsername(String username) {
		return null;
	}

}
