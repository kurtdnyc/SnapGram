package dev.snapgram.services;

import java.util.Set;

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.Tag;
import dev.snapgram.entities.User;

public interface PhotoService {

	Photo createPhoto(Photo photo);
	
	Photo getPhotoById(int id);
	
	Photo updatePhoto(Photo photo);
	
	boolean deletePhoto(int id);
}
