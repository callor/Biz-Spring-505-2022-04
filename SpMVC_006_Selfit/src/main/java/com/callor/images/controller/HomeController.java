package com.callor.images.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.images.service.SelfitService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final SelfitService selfitService;
	public HomeController(SelfitService selfitService) {
		this.selfitService = selfitService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		selfitService.startPage(model);
		log.debug(model.getAttribute("MENUMAPS").toString());
		return "home";
		
	}

	
	
}
