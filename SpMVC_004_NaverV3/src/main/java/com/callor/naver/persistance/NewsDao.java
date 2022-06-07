package com.callor.naver.persistance;

import java.util.List;

import com.callor.naver.model.NewsVO;

public interface NewsDao extends GenericDao<NewsVO, String>{

	/*
	 * GenericDao 를 상속받음으로 해서 기본 CRUD 5개의 method 는
	 * 만들지 않아도 된다
	 */
//	public List<NewsVO> selectAll();
//	public NewsVO findById(String id);
//	public int insert(NewsVO vo);
//	public int update(NewsVO vo);
//	public int detete(String id);
	
	// 기본 CRUD 외에 필요한 method 가 있을경우 별도로 얼마든지 추가할수 있다
	public List<NewsVO> findByTitle(String title);

	
	
}
