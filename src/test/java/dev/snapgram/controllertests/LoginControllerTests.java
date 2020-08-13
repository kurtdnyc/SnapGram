package dev.snapgram.controllertests;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import dev.snapgram.services.UserService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.snapgram.controllers.LoginController.class)
class LoginControllerTests {

	@MockBean
	UserService us;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void loginUserTest() {
		//need to implement
	}
	@Test
	void getCurrentSessionTest() {
		//need to implement
	}

}
