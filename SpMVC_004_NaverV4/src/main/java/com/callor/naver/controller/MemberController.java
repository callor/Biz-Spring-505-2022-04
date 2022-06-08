package com.callor.naver.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private final MemberService memberService;
	public MemberController(
			@Qualifier(QualifierConfig.SERVICE.MEMBER_V1)   
			MemberService memberService) {
		
		this.memberService = memberService;
		
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return null;
	}

	@RequestMapping(value="/join")
	public String join() {
		return null;
	}
	
	@RequestMapping(value="logout")
	public String logout() {
		return null;
	}
	
	@RequestMapping(value="/mypage")
	public String mypage() {
		return null;
	}
	
	
	
	
	
	
	
	
	
	

}
