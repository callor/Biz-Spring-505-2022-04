package com.callor.images.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.WorkOutDTO;
import com.callor.images.service.SelfitService;

@Controller
@RequestMapping(value="/workout")
public class SelfitController {

	private final SelfitService selfitService;
	public SelfitController(
			@Qualifier(QualifierConfig.SERVICE.SELFIT_V2)
			SelfitService selfitService) {
		
		this.selfitService = selfitService;
		
	}

	// localhost:8080/selfit/workout/dayset/01-001 URL 로 요청을 받고
	// sc_num 에 등급ID(01-001) 값을 받겠다 라는 선언
	@RequestMapping(value="/dayset/{sc_num}",method=RequestMethod.GET)
	public String daySet(@PathVariable("sc_num") String sc_num,Model model) {
		selfitService.getDaySetList(model,sc_num);
		return "workout/dayset";
	}
	
	@RequestMapping(value="/dayset/{sc_num}/{sc_id}",method=RequestMethod.GET)
	public String daySet(
			@PathVariable("sc_num") String sc_num,
			@PathVariable("sc_id") String sc_id,
			Model model) {
		
		selfitService.getDaySetList(model,sc_num,sc_id);
		return "workout/dayset";
		
	}
	
	@RequestMapping(value="/dayHealth/{sc_id}/{list_id}")
	public String dayHealth(
			@PathVariable("list_id") String listid,
			@PathVariable("sc_id") String sc_id,
			Model model) {
	
		WorkOutDTO health = selfitService.getDayHealth(sc_id, listid);
		model.addAttribute("HEALTH",health);
		return "workout/dayHealth";

	}
	
	
	
}
