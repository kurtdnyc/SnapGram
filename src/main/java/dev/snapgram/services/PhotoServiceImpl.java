package dev.snapgram.services;

import dev.snapgram.beans.Photo;
import dev.snapgram.daos.PhotoDAO;
import dev.snapgram.daos.PhotoDAOSpring;
import dev.snapgram.daos.UserDAO;
import dev.snapgram.daos.UserDAOSpring;

public class PhotoServiceImpl implements PhotoService{

	private PhotoDAO pdao;
	
	public PhotoServiceImpl() {
		this.pdao = new PhotoDAOSpring();
	}
	
	public PhotoServiceImpl(PhotoDAO pdao) {
		this.pdao=pdao;
	}

	@Override
	public Photo createPhoto(Photo photo) {
		return this.pdao.createPhoto(photo);
	}

	@Override
	public Photo getPhotoById(int id) {
		return this.pdao.getPhotoById(id);
	}


	@Override
	public Photo updatePhoto(Photo photo) {
		return this.pdao.updatePhoto(photo);
	}

	@Override
	public boolean deletePhoto(int id) {
		return this.pdao.deletePhoto(id);
	}


}
