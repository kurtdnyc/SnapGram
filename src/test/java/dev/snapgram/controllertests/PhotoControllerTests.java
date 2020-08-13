package dev.snapgram.controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.google.gson.Gson;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

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
	void createPhotoTest() throws Exception {
		
		String jsonUser = "{\"uId\":1,\"username\":\"mikeusername\",\"password\":\"mikepassword\",\"fname\":\"Mike\",\"lname\":\"Richards\"}";
		String jsonPhoto = "{\"photoId\":1,\"photo_url\":\"cat.jpg\",\"photoName\":\"cat\",\"photoDescription\":\"cat description\",\"user\":"
				+ jsonUser + "}";
		Gson gson = new Gson();
		
		Photo photo = gson.fromJson(jsonPhoto, Photo.class);
		Mockito.when(ps.createPhoto(photo)).thenReturn(photo);
		
		ResultActions ra = mvc.perform(post("/users/1/photos").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonPhoto));
		ra.andExpect(status().isOk());
		
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
