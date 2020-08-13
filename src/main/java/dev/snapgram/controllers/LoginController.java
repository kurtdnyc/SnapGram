package dev.snapgram.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.snapgram.dtos.LoginDTO;
import dev.snapgram.entities.User;
import dev.snapgram.exceptions.InvalidLoginException;
import dev.snapgram.services.UserService;

@Component
@RestController
public class LoginController {

	@Autowired
	UserService uServ;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User loginUser(@RequestBody LoginDTO dto, HttpServletResponse httpServletResponse) throws InvalidLoginException, IOException {
		User user = this.uServ.getUserByLogin(dto.getUsername(), dto.getPassword());
		httpServletResponse.sendRedirect("https://twitter.com/");

		return user;
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	@ResponseBody
//	public User getCurrentSession(HttpSession session){
//		User user = (User) session.getAttribute("loggedInAs");
//		return user;
//	}
}
