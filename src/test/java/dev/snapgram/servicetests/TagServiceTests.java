package dev.snapgram.servicetests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;

import dev.snapgram.beans.Photo;
import dev.snapgram.beans.Tag;
import dev.snapgram.daos.TagDAO;
import dev.snapgram.services.TagService;
import dev.snapgram.services.TagServiceImpl;

@TestMethodOrder(OrderAnnotation.class) 
class TagServiceTests {

	@Test
	@Order(1)
	void createTag() {
		Tag tag = new Tag(1,"nature");
		
		TagDAO tDao = Mockito.mock(TagDAO.class);
		
		Mockito.when(tDao.createTag(tag)).thenReturn(tag);

		TagService tServ = new TagServiceImpl(tDao);
		
		
		Assertions.assertEquals(1, tServ.createTag(tag).getTagId());
	}
	
	@Test
	@Order(2)
	void getTagById() {
		Tag tag = new Tag(1,"nature");
		
		TagDAO tDao = Mockito.mock(TagDAO.class);
		
		Mockito.when(tDao.getTagById(1)).thenReturn(tag);

		TagService tServ = new TagServiceImpl(tDao);
		
		
		Assertions.assertEquals("nature", tServ.getTagById(1).getTagName());
		
	}
	
	@Test
	@Order(3)
	void getPhotosByTag() {
		Tag tag = new Tag(1,"nature");
		
		Set<Photo> fakePhotos = new HashSet<Photo>();
		
		Photo flick = new Photo(3,null,"selfie","mad cute",1);
		
		Photo flick2 = new Photo(8,null,"group pic","we out here",2);
		Photo flick3 = new Photo(12,null,"lolol","ahfjhjfhjdsf",9);
		
	
		fakePhotos.add(flick);
		fakePhotos.add(flick2);
		fakePhotos.add(flick3);
		
		TagDAO tDao = Mockito.mock(TagDAO.class);
		
		Mockito.when(tDao.getPhotosByTag(tag)).thenReturn(fakePhotos);

		TagService tServ = new TagServiceImpl(tDao);
		
		Assertions.assertEquals(3, tServ.getPhotosByTag(tag).size());
		
		
	}

}
