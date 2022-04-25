package com.callor.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * Controller level 에 @RequestMapping을 설정하면
 * Controller 의 mapping 과 method 의 mapping 서로 연결되어
 * RequestMapping 을 구성한다
 * localhost:8080/school/student : StudentController 의 mapping 이 연결
 * localhost:8080/school/student/list : StudentController#list() 의 mapping 이 연결
 */
@RequestMapping(value="/student")
@Controller
public class StudentController {
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list() {
		return "student/list";
	}
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input() {
		return "student/input";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail() {
		return "student/detail_view";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update() {
		return "student/update";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete() {
		return "student/delete";
	}
	
	
	
	

}
