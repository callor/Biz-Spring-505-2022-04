package com.callor.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	// localhost:8080/school/student 또는
	// localhost:8080/school/student/ 또는
	@RequestMapping(value= {"","/"}, method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("LAYOUT","ST_LIST");
		return "home";
	}
	@RequestMapping(value= "/input", method=RequestMethod.GET)
	public String input(Model model) {
		model.addAttribute("LAYOUT","ST_INPUT");
		return "home";
	}
	
	

}
