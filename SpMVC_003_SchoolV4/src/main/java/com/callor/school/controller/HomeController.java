package com.callor.school.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.school.model.StudentVO;
import com.callor.school.persistance.StudentDao;

@Controller
public class HomeController {
	
	private final StudentDao stDao;
	public HomeController(StudentDao stDao) {
		this.stDao = stDao;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<StudentVO> stList = stDao.selectAll();
		for(StudentVO stVO : stList) {
			System.out.println(stVO.toString());
		}
		return "home";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String home(String username, String tel, Model model) {
		model.addAttribute("username", username);
		model.addAttribute("tel",tel);
		return "home";
	}
	
}
