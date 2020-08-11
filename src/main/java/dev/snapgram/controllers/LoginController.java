package dev.snapgram.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.snapgram.beans.User;

public class LoginController {

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User loginUser(@PathVariable String username, @PathVariable String password) {
		// might have to do a DTO like in project 1 
		// also dont know how to get session attributes in spring
		// .. yet ;)
		return null;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public User getCurrentSession() {
		return null;
		
	}
}
