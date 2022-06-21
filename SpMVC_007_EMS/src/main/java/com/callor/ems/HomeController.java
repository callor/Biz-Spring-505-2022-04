package com.callor.ems;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Value("#{naver['naver.username']}")
	private String naver_username;
	
	@Value("#{app['my.app']}")
	private String myApp;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.debug("Naver User Name {}", naver_username);
		log.debug("앱 이름 {}", myApp);
		
		return "home";
	}
	
	
	
}
