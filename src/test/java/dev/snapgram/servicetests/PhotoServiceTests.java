package dev.snapgram.servicetests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.Mockito;

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.User;
import dev.snapgram.repositories.PhotoRepository;
import dev.snapgram.repositories.UserRepository;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.PhotoServiceImpl;

@TestMethodOrder(OrderAnnotation.class) 
class PhotoServiceTests {

//	@Test
//	@Order(1)
//	void createPhoto() {
//		User bob = new User(1,"bobbyboy69@email.com","securepassword","bob","boberson");
//	//	Photo flick = new Photo(3,null,"selfie","mad cute",1);
//		
//		
//		PhotoRepository pDao = Mockito.mock(PhotoRepository.class);
//		
//		
//		Mockito.when(pDao.save(flick)).thenReturn(flick);
//
//		PhotoService pServ = new PhotoServiceImpl(pDao);
//		
//		
//		//Assertions.assertEquals(1, pServ.createPhoto(flick).getUserId());
//		
//	}
//	
//	@Test
//	@Order(2)
//	void getPhotoById() {
//		
//		Photo flick = new Photo(3,null,"selfie","mad cute",1);
//		
//		
//		PhotoRepository pDao = Mockito.mock(PhotoRepository.class);
//		
//		
//		Mockito.when(pDao.findById(3).get()).thenReturn(flick);
//
//		PhotoService pServ = new PhotoServiceImpl(pDao);
//		
//		
//		Assertions.assertEquals("selfie", pServ.getPhotoById(3).getPhotoName());
//	}
//	
//	@Test
//	@Order(3)
//	void updatePhoto() {
//		Photo flick = new Photo(3,null,"selfie","mad cute",1);
//		Photo updatedFlick = new Photo(3,null,"yikes","mad cute",1);
//		
//		
//		PhotoRepository pDao = Mockito.mock(PhotoRepository.class);
//		
//		
//		Mockito.when(pDao.save(flick)).thenReturn(updatedFlick);
//
//		PhotoService pServ = new PhotoServiceImpl(pDao);
//		
//		Photo photo = pServ.updatePhoto(flick);
//		Assertions.assertNotEquals("selfie", photo.getPhotoName());
//	}
//	
//	

}
