package dev.snapgram.services;

import java.util.Set;

import dev.snapgram.beans.Photo;
import dev.snapgram.beans.Tag;
import dev.snapgram.daos.TagDAO;
import dev.snapgram.daos.TagDAOSpring;

public class TagServiceImpl implements TagService{

	private TagDAO tDao;
	
	public TagServiceImpl() {
		this.tDao = new TagDAOSpring(); 
	}
	
	public TagServiceImpl(TagDAO tDao) {
		this.tDao=tDao;
	}

	@Override
	public Tag createTag(Tag tag) {
		return this.tDao.createTag(tag);
	}

	@Override
	public Tag getTagById(int id) {
		return this.tDao.getTagById(id);
	}

	@Override
	public Set<Photo> getPhotosByTag(Tag tag){
		return this.tDao.getPhotosByTag(tag);
	}


}
