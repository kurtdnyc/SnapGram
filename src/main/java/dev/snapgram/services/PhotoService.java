package dev.snapgram.services;


import dev.snapgram.entities.Photo;

public interface PhotoService {

	Photo createPhoto(Photo photo);
	
	Photo getPhotoById(int id);
	
	Photo updatePhoto(Photo photo);
	
	boolean deletePhoto(int id);
}
