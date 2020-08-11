package dev.snapgram.services;

import java.util.Set;

import dev.snapgram.beans.Photo;
import dev.snapgram.beans.Tag;

public interface TagService {
	Tag createTag(Tag tag);
	
	Set<Photo> getPhotosByTag(Tag tag);
}
