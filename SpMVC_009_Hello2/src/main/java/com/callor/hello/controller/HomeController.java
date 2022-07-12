package com.callor.hello.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.model.AddressVO;
import com.callor.hello.service.HomeService;

@Controller
public class HomeController {
	
	/*
	 * HomeService 인터페이스를 사용하여 객체를 선언하고
	 * 생성자를 통하여 주입을 받기 위한 준비 코드 작성
	 * 
	 * Spring 인터페이스 주입 패턴
	 * 
	 * 클래스를 통하여 객체를 선언하지 않고
	 * 인터페이스를 통해서 객체를 선언하므로써
	 * 결합도는 낮아지고 코드 응집도가 높아져서
	 * 코드를 확장(업그레이드) 하고자 할때 여러가지 유리한 패턴이 된다. 
	 * 
	 */
	private final HomeService homeService;
	public HomeController(
			@Qualifier(QualifyConfig.HOME_SERVCE_V1)  HomeService homeService) {
		this.homeService = homeService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		/*
		 * homeService 의 hello(), hello("홍길동"), goodBye(), goodBye("이몽룡")
		 * 메서드를 사용하는 HomeController 작성자는 아직 HomeServiceImpl 클래스의
		 * 메서들이 구체적으로 완성이 되지 않았지만
		 * 코드의 완성과 상관없이 자신의 코드를 완성할 수 있다.
		 */
		String hello = homeService.hello();
		hello = homeService.hello("홍길동");
		
		String goodBye = homeService.goodBye();
		goodBye = homeService.goodBye("이몽룡");
		
		return "home";
	}

	/*
	 * form 에 보내온 데이터를 각각의 문자열형 변수에 받기
	 */
	public String home(String ad_name, String ad_tel, String ad_addr) {
		homeService.insert(ad_name, ad_tel, ad_addr);
		return "home";
	}
	
	/*
	 * form 에서 보내온 데이터를 AddressVO 클래스 타입의 객체에 한번 받기
	 * 클래스 타입의 객체를 사용하여 method 간에 데이터를 보내면
	 * 단일 변수들을 나열하여 사용하는 것보다
	 * 코드의 가독성이 높아지고, 훨씬 효율적이 된다.
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String home(AddressVO addrress) {
		homeService.insert(addrress);
		return "home";
	}
	
	@RequestMapping(value="/findName",method=RequestMethod.GET)
	public String findByName(String ad_name, Model model) {
		AddressVO address = homeService.findByName(ad_name);
		model.addAttribute("ADDR",address);
		return "home";
	}
	
}
