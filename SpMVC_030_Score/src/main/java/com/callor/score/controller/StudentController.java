package com.callor.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

/*
 * Cors 오류가 발생하지 않도록 서버에서 설정하기
 * React 의 fetch 요청에 대하여 CORS 문제를 건너뛰도록 설정하기
 */
@CrossOrigin({"http://localhost:3000","http://127.0.0.1" })
@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService stService;
	
	// JSON type 으로 return
	@ResponseBody
	@RequestMapping(value={"/",""} ,method=RequestMethod.GET)
	
	// 학생리스트를 return 하기 위해 return type List<StudentVO>
	public List<StudentVO> home() {
		List<StudentVO> stList = stService.selectAll();
		return stList;
	}
	
	@ResponseBody
	@RequestMapping(value="/{st_num}/delete")
	public String delete(@PathVariable("st_num") String st_num) {
		int ret = stService.delete(st_num);
		if(ret > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

}
