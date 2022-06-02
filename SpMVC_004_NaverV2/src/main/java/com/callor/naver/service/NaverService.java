package com.callor.naver.service;

import java.util.List;

import com.callor.naver.model.BookVO;

public interface NaverService {

	public String queryString(String cat, String search);
	public List<BookVO> getNaverBook(String queryString);
	
}
