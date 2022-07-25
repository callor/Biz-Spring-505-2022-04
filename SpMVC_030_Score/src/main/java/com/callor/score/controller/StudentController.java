package com.callor.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService stService;
	
	@RequestMapping(value= {"/",""} , method=RequestMethod.GET)
	public String home(Model model) {
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STUDENTS", stList);
		return "student/list";
	}
	
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(String st_num) {
		
		return "student/detail";
	}
	
	
	// JSON type 으로 return
	@ResponseBody
	@RequestMapping(value="/json",method=RequestMethod.GET)
	// 학생리스트를 return 하기 위해 return type List<StudentVO>
	public List<StudentVO> home() {
		List<StudentVO> stList = stService.selectAll();
		return stList;
	}
	
}
