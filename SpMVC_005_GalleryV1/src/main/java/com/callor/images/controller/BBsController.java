package com.callor.images.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.images.model.BBsVO;
import com.callor.images.persistance.BbsDao;
import com.callor.images.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequestMapping(value="/bbs")
public class BBsController {

	
	@Autowired
	private BbsDao bbsDao;
	
	@Autowired
	private FileUpService fileService;
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(Model model) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		BBsVO bbsVO = BBsVO.builder()
						.b_date(dayFormat.format(date))
						.b_time(timeFormat.format(date))
						.b_writer("callor")
						.build();
		
		log.debug(bbsVO.toString());
		model.addAttribute("BBS",bbsVO);
		return "bbs/input";
		
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(BBsVO bbsVO, 
			@RequestParam("up_file")  MultipartFile file, Model model) {

		// "게시판 : " + bbsVO.toString()
		log.debug("게시판 : {}",bbsVO.toString());
		log.debug("업로드한 파일 이름 : {}", file.getOriginalFilename());

		try {
			String fileName = fileService.fileUp(file);
			model.addAttribute("FILE",fileName);
			return "home";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	
}
