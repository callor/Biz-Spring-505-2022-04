package com.callor.todo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;
import com.callor.todo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;

	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return "users/join";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		log.debug("회원가입 정보 {}",userVO);
		userService.insert(userVO);
		
		return "redirect:/login";
	
	}
	
	/*
	 * method 수준에서 권한 살펴보기
	 */
	@PreAuthorize("hasAnyRole(['ROLE_USER','ROLE_ADMIN'])")
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage(Principal principal) {
		
		/*
		 * Security 에서 login 한 사용자정보를 Controller 에서 보기 위한방법
		 * Principal 객체에 담겨있다.
		 * 단 사용자 이름만 추출할 수 있다
		 */
		String username = principal.getName();
		
		return "users/mypage";
	}
	
	
	/*
	 * @AuthenticationPrincipal
	 * UserVO 클래스 앞에 붙이면
	 * 로그인한 사용자 정보를 
	 * 객체에 담아준다
	 */
	@RequestMapping(value="/mypage2",method=RequestMethod.GET)
	public String mypage(@AuthenticationPrincipal  UserVO uerVO) {
	
		return "users/mypage";
	}
	
	
	
	
}
