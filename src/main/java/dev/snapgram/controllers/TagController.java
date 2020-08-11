package dev.snapgram.controllers;

import java.util.Set;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.snapgram.beans.Photo;
import dev.snapgram.beans.Tag;
import dev.snapgram.services.TagService;
import dev.snapgram.services.TagServiceImpl;

public class TagController {

	TagService tServ = new TagServiceImpl(null);
	
	@RequestMapping(value = "/tags", method = RequestMethod.POST)
	@ResponseBody
	public Tag createTag(@RequestBody Tag tag) {
		return tServ.createTag(tag);
	}
	
	
	@RequestMapping(value = "/tags/{tid}/photos", method = RequestMethod.GET)
	@ResponseBody
	public Set<Photo> getPhotosByTag(@PathVariable int tid) {
		Tag tag = tServ.getTagById(tid);
		return tServ.getPhotosByTag(tag);
	}
}
