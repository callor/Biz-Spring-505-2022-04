package com.callor.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.school.model.UserVO;

@Controller
@RequestMapping(value="/student")
public class StudentController {

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
}
