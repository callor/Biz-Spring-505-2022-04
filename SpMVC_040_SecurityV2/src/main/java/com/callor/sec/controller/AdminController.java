package com.callor.sec.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.sec.model.UserVO;
import com.callor.sec.service.AdminService;
import com.callor.sec.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String adminPage(Model model) {
		
		List<UserVO> userList = userService.selectAll();
		
		model.addAttribute("USERS",userList);
		model.addAttribute("LAYOUT","ADMIN_PAGE");
		return "home";
	}
	
	@RequestMapping(value="/userupdate",method=RequestMethod.GET)
	public String userUpdate(String username,String error,Model model) {
		
		UserVO userVO = userService.findById(username);
		model.addAttribute("USER",userVO);
		model.addAttribute("error",error);
		model.addAttribute("LAYOUT","ADMIN_USER");
		return "home";
	}
	
	/*
	 * Spring security 에서 로그인이 성공하면 Principal 이라는 클래스를
	 * 사용할 수 있다
	 * principal.getName() 를 실행하면 로그인한 사용자의 username 을
	 * 추출할 수 있다
	 */
	@RequestMapping(value="/userupdate",method=RequestMethod.POST)
	public String userUpdate(
			UserVO userVO, 
			Principal principal, 
			Model model) {
	
			String admin = principal.getName();
			log.debug("PR Name {}",admin);
			
			int ret = adminService.update(userVO,admin);
			if(ret < 0) {
				return String.format("redirect:/admin/userupdate?"
						+ "username=%s&error=ADMIN_PASS", userVO.getUsername());
			}
			
			return "redirect:/admin";
		
	}
	
}
