package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.domain.ScoreVO;

@Controller
public class ScoreController {
	
	@ResponseBody
	@RequestMapping(value="/print")
	public String printScore() {
		
		int intKor = 100;
		int intEng = 100;
		
		int intSum = intKor + intEng;
		
		return intSum + "";
	}

	
//	@RequestMapping(value="/score", method=RequestMethod.GET)
//	public String score() {
//		return "score";
//	}

	@RequestMapping(value="/score",method=RequestMethod.POST)
	public String score(ScoreVO scoreVO, Model model) {
		model.addAttribute("SCORE", scoreVO);
		return "score";
	}
	

}
