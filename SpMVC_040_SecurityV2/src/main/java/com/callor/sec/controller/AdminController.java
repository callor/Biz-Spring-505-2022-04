package com.callor.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String adminPage(Model model) {
		model.addAttribute("LAYOUT","ADMIN_PAGE");
		return "home";
	}
	
}
