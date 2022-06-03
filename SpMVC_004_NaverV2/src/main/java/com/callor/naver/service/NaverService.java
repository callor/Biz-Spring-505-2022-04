package com.callor.naver.service;

import java.util.List;

public interface NaverService {

	public String queryString(String cat, String search);
	public List<Object> getNaver(String queryString);
	
}
