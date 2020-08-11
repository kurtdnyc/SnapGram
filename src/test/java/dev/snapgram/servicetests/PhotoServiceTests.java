package dev.snapgram.servicetests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.Mockito;

import dev.snapgram.beans.Photo;
import dev.snapgram.beans.User;
import dev.snapgram.daos.PhotoDAO;
import dev.snapgram.daos.UserDAO;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.PhotoServiceImpl;

@TestMethodOrder(OrderAnnotation.class) 
class PhotoServiceTests {

	@Test
	@Order(1)
	void createPhoto() {
		User bob = new User(1,"bobbyboy69@email.com","securepassword","bob","boberson");
		Photo flick = new Photo(3,null,"selfie","mad cute",1);
		
		
		PhotoDAO pDao = Mockito.mock(PhotoDAO.class);
		
		
		Mockito.when(pDao.createPhoto(flick)).thenReturn(flick);

		PhotoService pServ = new PhotoServiceImpl(pDao);
		
		
		Assertions.assertEquals(1, pServ.createPhoto(flick).getUserId());
		
	}
	
	@Test
	@Order(2)
	void getPhotoById() {
		
		Photo flick = new Photo(3,null,"selfie","mad cute",1);
		
		
		PhotoDAO pDao = Mockito.mock(PhotoDAO.class);
		
		
		Mockito.when(pDao.getPhotoById(3)).thenReturn(flick);

		PhotoService pServ = new PhotoServiceImpl(pDao);
		
		
		Assertions.assertEquals("selfie", pServ.getPhotoById(3).getPhotoName());
	}
	
	@Test
	@Order(3)
	void updatePhoto() {
		Photo flick = new Photo(3,null,"selfie","mad cute",1);
		Photo updatedFlick = new Photo(3,null,"yikes","mad cute",1);
		
		
		PhotoDAO pDao = Mockito.mock(PhotoDAO.class);
		
		
		Mockito.when(pDao.updatePhoto(flick)).thenReturn(updatedFlick);

		PhotoService pServ = new PhotoServiceImpl(pDao);
		
		Photo photo = pServ.updatePhoto(flick);
		Assertions.assertNotEquals("selfie", photo.getPhotoName());
	}
	
	@Test
	@Order(4)
	void deletePhoto() {
		Photo flick = new Photo(3,null,"selfie","mad cute",1);
		
		
		
		PhotoDAO pDao = Mockito.mock(PhotoDAO.class);
		
		
		Mockito.when(pDao.deletePhoto(3)).thenReturn(true);

		PhotoService pServ = new PhotoServiceImpl(pDao);
		
		boolean result = pServ.deletePhoto(flick.getPhotoId());
		Assertions.assertEquals(result, true);
	}

}
