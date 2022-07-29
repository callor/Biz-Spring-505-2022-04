package com.callor.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.sec.model.UserVO;
import com.callor.sec.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(String exception, Model model) {
		
		model.addAttribute("exception",exception);
		model.addAttribute("LAYOUT","JOIN");
		return "home";
		
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		userService.insert(userVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(String error,String exception,Model model) {
		model.addAttribute("error",error);
		model.addAttribute("exception",exception);
		model.addAttribute("LAYOUT","LOGIN");
		return "home";
	}
	
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage(Model model) {
		model.addAttribute("LAYOUT","MYPAGE");
		return "home";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String username, String error, Model model) {
		
		model.addAttribute("LAYOUT","UPDATE");
		model.addAttribute("error",error);
		return "home";
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(UserVO userVO, Model model) {

		int ret = userService.update(userVO);
		if(ret < 0) {
			return String.format("redirect:/user/update?username=%s&error=%s",
					userVO.getUsername(),"PASS_FAIL");
		}
		
		
		return "redirect:/user/mypage?username=" +  userVO.getUsername();

	}
	
}


