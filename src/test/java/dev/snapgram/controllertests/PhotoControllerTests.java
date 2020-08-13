package dev.snapgram.controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.boot.test.mock.mockito.MockBean;

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.User;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.UserService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.snapgram.controllers.PhotoController.class)
class PhotoControllerTests {

	@MockBean
	PhotoService ps;
	@MockBean
	UserService us;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void createPhotoTest() {
		
		//not sure how to mock post requests
		
//		Mockito.when(us.getUserById(1)).thenReturn(new User(1, "Mike", "password123", "Mike", "Richardson"));
//		
//		ResultActions ra = mvc.perform(post("/users/1/photos")
//					.content(asJsonString(new Photo(0, "cat.jpg", "cat", "cat playing", us.getUserById(1), null))));
//		ra.andExpect(status().isOk());
		
	}
	
	@Test
	void getPhotoByIdTest() throws Exception {
		Mockito.when(us.getUserById(1)).thenReturn(new User(1, "Mike", "password123", "Mike", "Richardson"));
		Mockito.when(ps.getPhotoById(1)).thenReturn(new Photo(1, "", "cat", "cat desc",us.getUserById(1)));
		
		ResultActions ra = mvc.perform(get("/users/1/photos/1"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void editPhotoTest() {
		//not sure how to mock edit requests
	}
	
	@Test
	void deletePhotoTest() throws Exception {
		ResultActions ra = mvc.perform(delete("/users/1/photos/1"));
		ra.andExpect(status().isOk());
	}

}
