package dev.snapgram.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.Tag;
import dev.snapgram.repositories.TagRepository;


@Component
@Service
public class TagServiceImpl implements TagService{

	@Autowired
	TagRepository tr;
	
	
	public TagServiceImpl(TagRepository tr) {
		this.tr=tr;
	}

	@Override
	public Tag createTag(Tag tag) {
		return this.tr.save(tag);
	}

	@Override
	public Tag getTagById(int id) {
		return this.tr.findById(id).get();
	}

}
