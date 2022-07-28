package com.callor.sec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.callor.sec.model.UserVO;
import com.callor.sec.psersistance.UserDao;
import com.callor.sec.service.UserService;

public class UserServiceImplV1 implements UserService{

	@Autowired
	private UserDao userDao;

	// Bean 을 생성하는 Annotation 
	// 이 메서드를 자동실행하도록 하는 트릭
	@Bean
	public void create_table() {
		userDao.create_author_table();
		userDao.create_uesr_table();
	}
	
	@Override
	public void create_uesr_table() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create_author_table() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(UserVO vo) {
		return userDao.insert(vo);
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
