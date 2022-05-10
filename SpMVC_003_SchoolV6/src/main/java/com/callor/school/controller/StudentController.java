package com.callor.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.school.model.StudentVO;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	// localhost:8080/school/student 또는
	// localhost:8080/school/student/ 또는
	@RequestMapping(value= {"","/"}, method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("LAYOUT","ST_LIST");
		return "home";
	}
	@RequestMapping(value= "/input", method=RequestMethod.GET)
	public String input(Model model) {
		model.addAttribute("LAYOUT","ST_INPUT");
		return "home";
	}
	
	/*
	 * form에서 input 담긴 데이터를 수신하는 method
	 */
	@RequestMapping(value="/input",method=RequestMethod.POST)
	// form 에서 전달된 데이터를 VO 객체를 사용하여 받기
	public String input(StudentVO stVO) {
		System.out.println(stVO.toString());
		return "home";
	}
	
	// form에서 전달된 데이터를 개별 변수로 받기
	public String input(String st_num, 
				String st_name,String st_dept,int st_grade, 
				String st_tel, String st_addr) {
		
		System.out.println("학번:" + st_num);
		System.out.println("이름:" + st_name);
		System.out.println("학과:" + st_dept);
		System.out.println("학년:" + st_grade);
		System.out.println("전화:" + st_tel);
		System.out.println("주소:" + st_addr);
		return "home";
	}

	@ResponseBody
	@RequestMapping(value="/st_num_check",method=RequestMethod.GET)
	public String st_num_check(String st_num) {
		return "Hello Korea";
	}
	
	

}
