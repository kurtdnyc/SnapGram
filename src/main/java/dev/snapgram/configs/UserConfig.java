package dev.snapgram.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import dev.snapgram.beans.User;

@Component
@Configuration
public class UserConfig {
	
	@Bean
	public User emptyUser() {
		User u = new User(0,"me@email.com","password","Bob","Bobson");
		return u;
	}
}
