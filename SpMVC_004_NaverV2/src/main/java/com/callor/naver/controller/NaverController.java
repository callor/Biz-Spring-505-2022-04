package com.callor.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/naver")
@Controller
public class NaverController {
	
	private final NaverService naverService ;
	public NaverController(
			@Qualifier(QualifierConfig.SERVICE.NAVER_V2)  
			NaverService naverService) {
		this.naverService = naverService;
	}
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String home() {
		return "naver/search";
	}

	@ResponseBody
	@RequestMapping(value= {"/",""}, method=RequestMethod.POST)
	public List<Object> home(String cat, String search) {
		log.debug("카테고리 : " + cat);
		log.debug("검색어 : {} ", search);
		String queryString = naverService.queryString(cat, search);
		return naverService.getNaver(queryString);
	}
	
	
//	@RequestMapping(value="/books",method=RequestMethod.GET)
//	public String getBooks(String title, Model model) {
//		
//		log.debug("도서정보 : " + title);
//		String queryString = naverService.queryString("BOOK", title);
//		List<BookVO> bookList 
//			= naverService.getNaverBook(queryString);
//		
//		model.addAttribute("BOOKS",bookList);
//		return "naver/book_search";
//	
//	}

}
