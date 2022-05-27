package com.callor.school.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.school.model.StudentVO;
import com.callor.school.model.UserVO;
import com.callor.school.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {

	private final StudentService stService;
	public StudentController(StudentService stService) {
		this.stService = stService;
	}
	
	/*
	 * 만약 사용자의 로그인이 필요한 요청의 경우
	 * 요청받은 method 에 HttpSession 객체를 매개변수로 설정하고
	 * 코드 시작부분에서 httpSession 의 getAttribute("변수명") 을
	 * 사용하여 로그인된 정보를 추출한다
	 * 만약 추출한 정보가 null 이면 로그인 페이지로 점프하고
	 * null 아니면 요청에 대한 응답을 실행한다
	 */
	@RequestMapping(value={"/", ""},method=RequestMethod.GET)
	public String list(HttpSession session) {
		UserVO userVO = (UserVO) session.getAttribute("USER");
		if(userVO == null) {
			return "redirect:/user/login";
		} else {
			return "redirect:/";
		}
	}

	/*
	 * @ResponseBody
	 * Controller method 에서 문자열을 return 하면
	 * 문자열을 web client 에게 그대로 전송하는 역할을 하도록
	 * 지시하는 Annotation 이다
	 * 
	 * pom.xml 에 jackson-bind Dependency를 추가하면
	 * List, 객체(VO) 등등의 데이터를 json type 으로
	 * 변환하여 web client 전송한다
	 */
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<StudentVO> getList() {
		List<StudentVO> stList = stService.selectAll();
		return stList;
	}

	@ResponseBody
	@RequestMapping(value="/{st_num}/getter",method=RequestMethod.GET)
	public StudentVO getStudent(@PathVariable("st_num") String st_num) {
		StudentVO student = stService.findById(st_num);
		return student;
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Model model) {
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STLIST",stList);
		return null;
	}
	
}
