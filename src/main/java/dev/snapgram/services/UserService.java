package dev.snapgram.services;

import dev.snapgram.beans.User;

public interface UserService {

	User createUser(User user);
	
	User getUserById(int id);
	
	User getUserByLogin(String username, String password);
}
