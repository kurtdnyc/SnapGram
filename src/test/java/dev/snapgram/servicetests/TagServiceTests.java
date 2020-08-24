//package dev.snapgram.servicetests;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.mockito.Mockito;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Order;
//
//import dev.snapgram.entities.Photo;
//import dev.snapgram.entities.Tag;
//import dev.snapgram.repositories.TagRepository;
//import dev.snapgram.services.TagService;
//import dev.snapgram.services.TagServiceImpl;
//
//@TestMethodOrder(OrderAnnotation.class) 
//class TagServiceTests {
//
//	@Test
//	@Order(1)
//	void createTag() {
//		Tag tag = new Tag(1,"nature");
//		
//		TagRepository tDao = Mockito.mock(TagRepository.class);
//		
//		Mockito.when(tDao.save(tag)).thenReturn(tag);
//
//		TagService tServ = new TagServiceImpl(tDao);
//		
//		
//		Assertions.assertEquals(1, tServ.createTag(tag).getTagId());
//	}
//	
//	@Test
//	@Order(2)
//	void getTagById() {
//		Tag tag = new Tag(1,"nature");
//		
//		TagRepository tDao = Mockito.mock(TagRepository.class);
//		
//		Mockito.when(tDao.findById(1).get()).thenReturn(tag);
//
//		TagService tServ = new TagServiceImpl(tDao);
//		
//		
//		Assertions.assertEquals("nature", tServ.getTagById(1).getTagName());
//		
//	}
//	
//
//
//}
