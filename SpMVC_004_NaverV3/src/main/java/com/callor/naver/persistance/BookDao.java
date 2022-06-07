package com.callor.naver.persistance;

import java.util.List;

import com.callor.naver.model.BookVO;

public interface BookDao extends GenericDao<BookVO, String>{

	/*
	 * 데이터 조회 method 를 구현할때
	 * PK(findById) 를 기준으로 조회하는 method 는 
	 * 		return type 을 VO 를 사용한다
	 * PK 가 아닌 칼럼을 기준으로  조회를 할때는
	 * 		데이터가 1개만 있을 것이라는 보장이 지금은 있더라도
	 * 		return type 을 반드시 List<VO> 를 사용해야 한다
	 */
	public List<BookVO> findByTitle(String title);
	public List<BookVO> findByAuthor(String author);
	public List<BookVO> findByPublisher(String publisher);
	public List<BookVO> findByPrice(int price);
	
	public void create_book_table() ;
	
	
}
