package com.callor.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return null;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username, HttpSession httpSession) {
		httpSession.setAttribute("USERNAME", username);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("USERNAME");
		return "redirect:/";
	}
	

}
