package com.callor.naver.service;

import java.util.List;

import com.callor.naver.model.NaverBookVO;

public interface NaverService {

	public String queryString(String cat, String search);
	public List<NaverBookVO> getNaverBook(String queryString);
	
}
