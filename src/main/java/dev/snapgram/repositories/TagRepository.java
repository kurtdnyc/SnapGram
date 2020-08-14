package dev.snapgram.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.snapgram.entities.Tag;


@Component
@Repository
public interface TagRepository extends CrudRepository<Tag,Integer>{
	
	Set<Tag> findByTagName(String tagName);
}
