package dev.snapgram.services;

import java.util.Set;

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.Tag;

public interface TagService {
	
	Tag createTag(Tag tag);
	Tag getTagById(int id);
}
