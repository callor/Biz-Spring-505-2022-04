package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class UserController {

	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		// return "join";
		// views/user/join.jsp 를 rendering 하여 클라이언트에게 응답
		return null;
	}

	/*
	 * 일반적인 Controller 의 method 에서 문자열 또는 null 값을
	 * return 하면 *.jsp 파일을 rendering 하여 응답하는 
	 * 
	 * @ResponseBody 가 부착된 Controller 의 method에서
	 * 문자열을 return 그 문자열을 client(web browser) 에게 직접 전달하라는 것
	 */
	@ResponseBody
	@RequestMapping(value="/join",method=RequestMethod.POST, 
			produces = "text/html;charset=UTF-8")
	public String join(String username, String password) {
		return username;
	}
	
	
}
