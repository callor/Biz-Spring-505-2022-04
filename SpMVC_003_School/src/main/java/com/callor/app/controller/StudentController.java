package com.callor.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.app.domain.StudentVO;
import com.callor.app.service.StudentService;

@Controller
public class StudentController {
	/*
	 * Controller 에서 Service interface를 상속받은
	 * 클래스 중에 한가지를 사용하고자 한다.
	 * 전통적인 java 에서는 : 인터페이스 객체 = new 클래스생성자()
	 * 와 같이 사용한다.
	 * 
	 *  spring framework project 에서는
	 *  private final 인터페이스 객체 와 같이 선언하고
	 *  임의 생성자를 만들어 argument 로 전달받아
	 *  객체에 대입하는 코드를 만들어 둔다
	 *  
	 *  그러면
	 *  미리 bean 으로 생성되어 있는 객체들 중에
	 *  자동으로 주입이 된다.
	 */
	private final StudentService stService;
	public StudentController(StudentService stService) {
		this.stService = stService;
	}
	
	@RequestMapping(value="/student",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STUDENTS", stList);
		return "student/list_view";
	}
	
	@RequestMapping(value="/student/detail",method=RequestMethod.GET)
	public String detail(String stNum, Model model) {
		
		StudentVO stVO = stService.findById(stNum);
		model.addAttribute("STUDENT", stVO);
		
		return "student/detail";
	}
	
	@RequestMapping(value="/student/insert",
						method=RequestMethod.GET)
	public String insert( ) {
		return "student/insert";
	}
	
	

}
