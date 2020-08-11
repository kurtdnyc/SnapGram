package dev.snapgram.services;

import java.util.Set;

import dev.snapgram.beans.Photo;
import dev.snapgram.beans.User;

public interface PhotoService {

	Photo createPhoto(Photo photo);
	
	Photo getPhotoById(int id);
	
	Set<Photo> getPhotosByUser(User user);
}
