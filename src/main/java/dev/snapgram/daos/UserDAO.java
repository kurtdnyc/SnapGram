package dev.snapgram.daos;

import dev.snapgram.beans.User;

public interface UserDAO {
	
	User createUser(User user);
	
	User getUserById(int id);
	
	User getUserByLogin(String username, String password);
}
