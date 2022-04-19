package com.callor.hello;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * @Keyword 
 * Annotation(주석)
 * 역할 부여는 Keyword
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(String st_num1, String st_num2, Model model) {
		int intNum1 = Integer.valueOf(st_num1);
		int intNum2 = Integer.valueOf(st_num2);
		int intSum = intNum1 + intNum2;
		model.addAttribute("result", intSum);
		return "home";
	}

	@RequestMapping(value = "/korea",method=RequestMethod.GET)
	public String korea(String st_name, Model model) {
		model.addAttribute("result", st_name);
		return "korea";
	}
	@RequestMapping(value = "/korea",method=RequestMethod.POST)
	public String korea(String st_name,String st_num,Model model) {
		model.addAttribute("result", st_name);
		return "korea";
	}


}
