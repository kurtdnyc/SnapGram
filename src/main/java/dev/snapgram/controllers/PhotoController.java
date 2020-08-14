package dev.snapgram.controllers;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.Tag;
import dev.snapgram.entities.User;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.PhotoServiceImpl;
import dev.snapgram.services.TagService;
import dev.snapgram.services.UserService;
import dev.snapgram.services.UserServiceImpl;

@Component
@RestController
public class PhotoController {

	@Autowired
	PhotoService pServ;
	@Autowired
	UserService uServ;
	@Autowired
	TagService tServ;
	
	@RequestMapping(value = "/users/{uid}/photos", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Photo createPhoto(@RequestBody Photo photo, @PathVariable int uid) {
		
		// first get userbyuserid
		System.out.println(uid);
		System.out.println(photo);
		User currUser = uServ.getUserById(uid);
		System.out.println(currUser);
		photo.setUser(currUser);
		
		return this.pServ.createPhoto(photo);
	}
	
	@RequestMapping(value = "/users/{uid}/photos/{pid}", method = RequestMethod.GET)
	@ResponseBody
	public Photo getPhotoById(@PathVariable int pid) {
		return this.pServ.getPhotoById(pid);
	}
	
	@RequestMapping(value = "/users/{uid}/photos",method = RequestMethod.GET)
	@ResponseBody
	public Set<Photo> getPhotos(@PathVariable int uid,@RequestParam(required = false) String hashtag){
		if(hashtag != null) {
			Set<Tag> tags = this.tServ.getTagsByName(hashtag);
			Set<Photo> photos = new HashSet<Photo>();
			for(Tag tag : tags) {
				photos.add(tag.getPhoto());
			}
			return photos;
		}
		return this.uServ.getUserById(uid).getPhotos();
	}
	
	@RequestMapping(value = "/users/{uid}/photos", method = RequestMethod.PUT)
	@ResponseBody
	public Photo editPhoto(@RequestBody Photo photo, @PathVariable int uid) {
	//	photo.setUserId(uid); 
		return this.pServ.updatePhoto(photo);
	}
	
	
	
	@RequestMapping(value = "/users/{uid}/photos/{pid}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deletePhoto(@PathVariable int pid) {
		return this.pServ.deletePhoto(pid);
	}
	
}
