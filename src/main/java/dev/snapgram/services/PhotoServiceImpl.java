package dev.snapgram.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.snapgram.entities.Photo;
import dev.snapgram.repositories.PhotoRepository;
import dev.snapgram.repositories.UserRepository;

@Component
@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	PhotoRepository pr;

	@Override
	public Photo createPhoto(Photo photo) {
		return this.pr.save(photo);
	}

	@Override
	public Photo getPhotoById(int id) {
		return this.pr.findById(id).get();
	}


	@Override
	public Photo updatePhoto(Photo photo) {
		return this.pr.save(photo);
	}

	@Override
	public boolean deletePhoto(int id) {
		pr.deleteById(id);
		return true;
	}


}
