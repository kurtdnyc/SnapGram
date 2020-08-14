package dev.snapgram.controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import dev.snapgram.dtos.LoginDTO;
import dev.snapgram.entities.User;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.TagService;
import dev.snapgram.services.UserService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.snapgram.app.SnapGramSpringApplication.class)
class UserControllerTests {
	@MockBean
	PhotoService ps;
	@MockBean
	UserService us;
	@MockBean
	TagService ts;
	
	@Autowired
	MockMvc mvc;
	private static Gson gson = new Gson();
	@Test
	void loginTest() throws Exception {
		
		String json = "{\r\n" + 
				"    \"username\":\"mike123\",\r\n" + 
				"    \"password\":\"password\"\r\n" + 
				"}";
		String jsonUser = "{\"userId\": 1, \"username\": \"mike123\", \"password\": \"password\", \"fName\": \"Michael\", \"lName\": \"Scott\"}";
		
		
		
		LoginDTO loginDTO = gson.fromJson(json, LoginDTO.class);
		User user = gson.fromJson(jsonUser, User.class);
		
		Mockito.when(us.getUserByLogin(loginDTO.getUsername(), loginDTO.getPassword())).thenReturn(user);
		ResultActions ra = mvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void createUserTest() throws Exception {
		String jsonUser = "{\"userId\": 1, \"username\": \"mike123\", \"password\": \"password\", \"fName\": \"Michael\", \"lName\": \"Scott\"}";
		
		User user = gson.fromJson(jsonUser, User.class);
		
		Mockito.when(us.createUser(user)).thenReturn(user);
		ResultActions ra = mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonUser));
		ra.andExpect(status().is(201));
	}
	
	@Test
	void getUserByIdTest() throws Exception {
		ResultActions ra = mvc.perform(get("/users/1"));
		ra.andExpect(status().is(200));
	}
	
	@Test
	void getUserByUsernameTest() throws Exception {
		ResultActions ra = mvc.perform(get("/users?username=mike123"));
		ra.andExpect(status().is(200));
	}

}
