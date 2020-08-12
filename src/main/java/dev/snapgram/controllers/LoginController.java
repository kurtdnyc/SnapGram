package dev.snapgram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.snapgram.dtos.LoginDTO;
import dev.snapgram.entities.User;
import dev.snapgram.exceptions.InvalidLoginException;
import dev.snapgram.services.UserService;

public class LoginController {

	@Autowired
	UserService uServ;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User loginUser(@RequestBody LoginDTO dto) {
		try {
			User user = this.uServ.getUserByLogin(dto.getUsername(), dto.getPassword());
			// create session attribute
			// redirect to home page
			return null;
		} catch (InvalidLoginException e) {
			e.toString();
			//try again
			return null;
		}
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public User getCurrentSession() {
		// get user from session attribute
		return null;
		
	}
}
