package com.callor.sec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.sec.model.AuthorityVO;
import com.callor.sec.model.UserVO;
import com.callor.sec.psersistance.UserDao;
import com.callor.sec.service.UserService;

@Service
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
		
		List<UserVO> userList = userDao.selectAll();
		List<AuthorityVO> authList = new ArrayList<>();
		
		if(userList == null || userList.size() < 1) {
		
			/*
			 * 최초로 회원가입을 하면 Enabled 를 true
			 * ADMIN, USER 권한을 부여한다
			 */
			vo.setEnabled(true);
			authList.add(AuthorityVO.builder()
					.username(vo.getUsername())
					.authority("ROLE_ADMIN")
					.build());
			authList.add(AuthorityVO.builder()
					.username(vo.getUsername())
					.authority("ROLE_USER")
					.build());
			
		} else {
			authList.add(AuthorityVO.builder()
					.username(vo.getUsername())
					.authority("ROLE_USER")
					.build());
		}
		
		userDao.roleInsert(authList);
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

	@Override
	public int roleInsert(List<AuthorityVO> authList) {
		// TODO Auto-generated method stub
		return 0;
	}

}
