package com.callor.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.config.NaverConfig;
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
			@Qualifier(QualifierConfig.SERVICE.NAVER_V1)  
			NaverService naverService) {
		this.naverService = naverService;
	}
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String home() {
		return "naver/search";
	}

	@RequestMapping(value= {"/",""}, 
					method=RequestMethod.POST,
					produces = "application/json;charset=UTF-8")
	public String home(String cat, String search, Model model) {
		log.debug("카테고리 : " + cat);
		log.debug("검색어 : {} ", search);
		String queryString = naverService.queryString(cat, search);
		List<Object> bookList = naverService.getNaver(queryString);
		
		model.addAttribute("BOOKS",bookList);
		return "naver/book_search";
	}
	
	@RequestMapping(value="/books",method=RequestMethod.GET)
	public String book_search(String title, Model model) {
	
		String queryString = naverService.queryString("BOOK", title);
		List<Object> bookList = naverService.getNaver(queryString);
		model.addAttribute("BOOKS",bookList);
		return "naver/book_search";
	}
	
	/*
	 * ISBN 코드를 전달받아 Naver 에 검색한 후
	 * 한개의 도서 정보만 JSON type 으로 보내기
	 */
	@ResponseBody
	@RequestMapping(value="/{isbn}/book",method=RequestMethod.GET
			,produces = NaverConfig.APP_JSON)
	
	public Object book(@PathVariable("isbn") String isbn) {
		String queryString = naverService.queryString("BOOK", isbn);
		List<Object> bookList = naverService.getNaver(queryString);
		log.debug(bookList.toString());
		log.debug(bookList.get(0).toString());
		
		return bookList.get(0);
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
