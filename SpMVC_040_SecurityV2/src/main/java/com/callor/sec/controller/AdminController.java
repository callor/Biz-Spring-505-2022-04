package com.callor.sec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.sec.model.UserVO;
import com.callor.sec.service.UserService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String adminPage(Model model) {
		
		List<UserVO> userList = userService.selectAll();
		
		model.addAttribute("USERS",userList);
		model.addAttribute("LAYOUT","ADMIN_PAGE");
		return "home";
	}
	
}
