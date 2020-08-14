package dev.snapgram.controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.google.gson.Gson;

import dev.snapgram.entities.Tag;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.TagService;
import dev.snapgram.services.UserService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.snapgram.app.SnapGramSpringApplication.class)
class TagControllerTests {

	@MockBean
	TagService ts;
	@MockBean
	PhotoService ps;
	@MockBean
	UserService us;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void createTagTest() throws Exception {
		String json = "{\"tagId\": 1, \"tagName\": \"meow\"}";
		
		Gson gson = new Gson();
		
		Tag tag = gson.fromJson(json, Tag.class);
		
		Mockito.when(ts.createTag(tag)).thenReturn(tag);
		ResultActions ra = mvc.perform(post("/users/2/photos/1/tags").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
		ra.andExpect(status().is(201));
	}
	@Test
	void deleteTagById() throws Exception {
		ResultActions ra = mvc.perform(delete("/users/1/photos/1/tags/1"));
		ra.andExpect(status().is(200));
	}

}
