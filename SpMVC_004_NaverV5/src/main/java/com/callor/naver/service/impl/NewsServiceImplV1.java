package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.naver.model.NewsVO;
import com.callor.naver.service.NewsService;

@Service("newsServiceV1")
public class NewsServiceImplV1 implements NewsService{

	@Override
	public List<NewsVO> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NewsVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewsVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NewsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NewsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
