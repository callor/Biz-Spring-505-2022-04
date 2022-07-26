package com.callor.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String detail(@RequestParam("st_num") String st_num,Model model) {
		StudentVO student = stService.findById(st_num);
		model.addAttribute("STUDENT",student);
		return "student/detail";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String  st_num, Model model) {
		StudentVO student = stService.findById(st_num);
		model.addAttribute("STUDENT",student);
		return "student/input";
	}
	
	/*
	 * student/update?st_num=S001 로 input form 에서
	 * 저장 버튼을 클릭했을때
	 * form 에 action 이 설정되어 있지 않기 때문에
	 * POST 전송도 같은 주소로 요청이 된다
	 * 이때 주소창에 st_num=S001 이라는 변수가 설정되어 있기 때문에
	 * 
	 * form 에  st_num 항목을 설정하지 않아도 StudentVO 의 st_num 변수에
	 * 학번이 자동으로 담기게 된다.
	 * 
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(StudentVO student) {
		
		stService.update(student);
		String retStr 
			= String.format("redirect:/student/detail?st_num=%s", 
						student.getSt_num());
		return  retStr;
		
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
