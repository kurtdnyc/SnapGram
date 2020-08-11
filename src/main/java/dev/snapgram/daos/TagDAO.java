package dev.snapgram.daos;

import java.util.Set;

import dev.snapgram.beans.Photo;
import dev.snapgram.beans.Tag;

public interface TagDAO {
	
	Tag createTag(Tag tag);
	
	Tag getTagById(int id);
	
	Set<Photo> getPhotosByTag(Tag tag);

}
