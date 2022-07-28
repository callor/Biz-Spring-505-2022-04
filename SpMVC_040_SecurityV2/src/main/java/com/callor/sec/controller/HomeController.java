package com.callor.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	
	@RequestMapping(value="/guest",method=RequestMethod.GET)
	public String guest() {
		return null;
	}
	

}
