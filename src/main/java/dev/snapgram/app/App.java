package dev.snapgram.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.snapgram.beans.User;
import dev.snapgram.configs.UserConfig;


public class App {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);
		
		User u = ac.getBean("emptyUser", User.class);
		
		System.out.println(u);
	}
}
