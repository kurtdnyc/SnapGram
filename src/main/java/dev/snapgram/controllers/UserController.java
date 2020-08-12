package dev.snapgram.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public User createUser(@RequestBody User user) {
		return this.uServ.createUser(user);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public User getUserById(@PathVariable int id) {
		return this.uServ.getUserById(id);
	}
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserByUsername(String username) {
		// for searching
		// return the users page not a user object
		return null;
	}
	
	@RequestMapping(value = "/users/{uid}/photos", method = RequestMethod.GET)
	@ResponseBody
	public Set<Photo> getUsersPhotos(@PathVariable int uid) {
		return this.uServ.getUserById(uid).getPhotos();
	}
}


//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER NOT FOUND");
// @RequestParam String queryParam;
