package dev.snapgram.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.User;
import dev.snapgram.services.UserService;
import dev.snapgram.services.UserServiceImpl;

@Component
@RestController
public class UserController {

	@Autowired
	UserService uServ;
	
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		return this.uServ.createUser(user);
	}
	
	@RequestMapping(value = "/users/{uid}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserById(@PathVariable int uid) {
		return this.uServ.getUserById(uid);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public User getUserByUsername(@RequestParam String username) {
		return this.uServ.getUserByUsername(username);
	}
	
}


//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER NOT FOUND");
// @RequestParam String queryParam;
