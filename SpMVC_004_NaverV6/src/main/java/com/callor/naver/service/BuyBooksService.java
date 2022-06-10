package com.callor.naver.service;

import java.util.List;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.BuyBooksVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.BuyBooksDao;

public interface BuyBooksService extends BuyBooksDao{

	public int insert(UserVO userVO, BookVO bookVO);
	public List<String> findByDate();
	public List<BuyBooksVO> findByUserNameAndDate(String username, String buydate);
	
}
