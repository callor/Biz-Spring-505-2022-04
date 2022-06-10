package com.callor.naver.service;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.BuyBooksDao;

public interface BuyBooksService extends BuyBooksDao{

	public int insert(UserVO userVO, BookVO bookVO);
	
}
