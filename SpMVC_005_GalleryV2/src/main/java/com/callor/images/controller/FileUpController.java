package com.callor.images.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.model.BBsVO;
import com.callor.images.service.BBsService;
import com.callor.images.service.impl.FileServiceImplV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/file")
public class FileUpController {
	
	
	private final BBsService bbsService;
	public FileUpController(BBsService bbsService) {
		// TODO Auto-generated constructor stub
		this.bbsService = bbsService;
	}
	
	
	/*
	 * MultipartHttpServletRequest
	 * 여러개의 파일을 동시에 업로드 할때
	 * 파일들의 정보를 동시에 수신하는 용도의 도구
	 * 
	 * 
	 */
	@RequestMapping(value="/fileups",method=RequestMethod.GET)
	public String upFiles(
			@ModelAttribute("bbsVO")
			BBsVO bbsVO,
			Model mode) {
		return null;
	}
	
	@RequestMapping(value="/fileups",method=RequestMethod.POST)
	public String upFiles(
			
			@ModelAttribute("bbsVO")
			BBsVO bbsVO, 
			MultipartHttpServletRequest mFiles, 
			
			Model mode) {
		
			bbsService.insertBbsAndFiles(bbsVO, mFiles);
		
		
		return null;

	}
	
	@ModelAttribute("bbsVO")
	private BBsVO bbsVO() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		BBsVO bbsVO = BBsVO.builder()
						.b_date(dayFormat.format(date))
						.b_time(timeFormat.format(date))
						.b_writer("callor")
						.build();
		log.debug(bbsVO.toString());
		return bbsVO;
	}
	
	
	

}
