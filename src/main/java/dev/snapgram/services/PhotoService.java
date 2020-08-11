package dev.snapgram.services;

import java.util.Set;

import dev.snapgram.beans.Photo;
import dev.snapgram.beans.Tag;
import dev.snapgram.beans.User;

public interface PhotoService {

	Photo createPhoto(Photo photo);
	
	Photo getPhotoById(int id);
	
	Photo updatePhoto(Photo photo);
	
	boolean deletePhoto(int photo);
}
