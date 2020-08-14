package dev.snapgram.controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Content;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.google.gson.Gson;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import dev.snapgram.entities.Photo;
import dev.snapgram.entities.User;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.TagService;
import dev.snapgram.services.UserService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.snapgram.controllers.PhotoController.class)
class PhotoControllerTests {

	@MockBean
	PhotoService ps;
	@MockBean
	UserService us;
	@MockBean
	TagService ts;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void createPhotoTest() throws Exception {
		
		String json = "{\"photoId\": 2, \"photoUrl\": \"twitter.com\", \"photoName\": \"Dog\", \"photoDescription\": \"My adorable dog\"}";

		Gson gson = new Gson();
		
		Photo photo = gson.fromJson(json, Photo.class);
		
		Mockito.when(ps.createPhoto(photo)).thenReturn(photo);
		ResultActions ra = mvc.perform(post("/users/1/photos").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
		ra.andExpect(status().isOk());
		
	}
	
	@Test
	void getPhotoByIdTest() throws Exception {
		ResultActions ra = mvc.perform(get("/users/1/photos/1"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void editPhotoTest() throws Exception {
		String json = "{\"photoId\": 1, \"photoUrl\": \"facebook.com\", \"photoName\": \"Dog\", \"photoDescription\": \"My adorable dog\"}";

		Gson gson = new Gson();
		
		Photo photo = gson.fromJson(json, Photo.class);
		
		Mockito.when(ps.createPhoto(photo)).thenReturn(photo);
		ResultActions ra = mvc.perform(put("/users/1/photos").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void deletePhotoTest() throws Exception {
		ResultActions ra = mvc.perform(delete("/users/1/photos/1"));
		ra.andExpect(status().isOk());
	}

}
