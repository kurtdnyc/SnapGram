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

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.Tag;
import dev.snapgram.services.TagService;
import dev.snapgram.services.TagServiceImpl;

@Component
@Controller
public class TagController {

	@Autowired
	TagService tServ;
	
	@RequestMapping(value = "/tags", method = RequestMethod.POST)
	@ResponseBody
	public Tag createTag(@RequestBody Tag tag) {
		return this.tServ.createTag(tag);
	}
	
	
	@RequestMapping(value = "/tags/{tid}", method = RequestMethod.GET)
	@ResponseBody
	public Photo getPhotosByTag(@PathVariable int tid) {
		return this.tServ.getTagById(tid).getPhoto();
	}
}
