package dev.snapgram.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.snapgram.beans.Photo;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.PhotoServiceImpl;
import dev.snapgram.services.UserService;
import dev.snapgram.services.UserServiceImpl;


public class PhotoController {

	PhotoService pServ = new PhotoServiceImpl(null);

	
	@RequestMapping(value = "/users/{uid}/photos", method = RequestMethod.POST)
	@ResponseBody
	public Photo createPhoto(@RequestBody Photo photo, @PathVariable int uid) {
		photo.setUserId(uid);
		return pServ.createPhoto(photo);
	}
	
	@RequestMapping(value = "/users/{uid}/photos/{pid}", method = RequestMethod.GET)
	@ResponseBody
	public Photo getPhotoById(@PathVariable int pid) {
		return pServ.getPhotoById(pid);
	}
	
	
	
	@RequestMapping(value = "/users/{uid}/photos", method = RequestMethod.PUT)
	@ResponseBody
	public Photo editPhoto(@RequestBody Photo photo, @PathVariable int uid) {
		photo.setUserId(uid); // probably redundant if done first on the front end 
		return pServ.updatePhoto(photo);
	}
	
	
	
	@RequestMapping(value = "/users/{uid}/photos/{pid}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deletePhoto(@PathVariable int pid) {
		return pServ.deletePhoto(pid);
	}
	
}
