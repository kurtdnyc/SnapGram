package dev.snapgram.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.snapgram.entities.Tag;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.TagService;


@Component
@Controller
public class TagController {

	@Autowired
	TagService tServ;
	@Autowired
	PhotoService pserv;

	
	@RequestMapping(value = "users/{uid}/photos/{pid}/tags", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Tag createTag(@RequestBody Tag tag,@PathVariable int pid) {
		tag.setPhoto(pserv.getPhotoById(pid));
		return this.tServ.createTag(tag);
	}
	
	@RequestMapping(value = "users/{uid}/photos/{pid}/tags/{tid}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteTag(@PathVariable int tid) {
		return this.tServ.deleteTag(tid);
	}
	
}
