package dev.snapgram.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.User;

@Component
@Repository
public interface PhotoRepository extends CrudRepository<Photo,Integer>{
	
}
