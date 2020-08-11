package dev.snapgram.daos;

import java.util.Set;

import dev.snapgram.beans.Photo;
import dev.snapgram.beans.User;

public interface PhotoDAO {
	
	Photo createPhoto(Photo photo);
	
	Photo getPhotoById(int id);
	
	Photo updatePhoto(Photo photo);
	
	boolean deletePhoto(int id);
}
