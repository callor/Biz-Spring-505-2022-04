package com.callor.school.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.school.model.UserVO;
import com.callor.school.pesistance.UserDao;
import com.callor.school.service.UserService;

/*
 * UserServiceImplV1 클래스를 Component(bean) 로 등록하기
 */
@Service
public class UserServiceImplV1 implements UserService {

	private final UserDao userDao;
	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public UserVO login(UserVO userVO) {

		String username = userVO.getUsername();
		String password = userVO.getPassword();
		
		if(username.equalsIgnoreCase("callor")
				&& password.equals("12341234")){
			userVO.setName("홍길동");
			userVO.setRole("ADMIN");
			userVO.setEmail("callor@callor.com");
		} else {
			userVO = null;
		}
		return userVO;
	}
	
	/*
	 * 회원가입 처리를 하기
	 * 1. 최초로 회원가입을 실행하는 
	 * 		가입자는 ADMIN role 을 부여하기
	 * 2. 두번째 이후 회원가입을 실행하는 
	 * 		가입자는 USER role 부여하기
	 */
	@Override
	public UserVO join(UserVO userVO) {

		// 1. user table 에 데이터가 있는지 확인하기 위하여
		//		전체 데이터를 select 하기
		List<UserVO> userList = userDao.selectAll();
		// 만약 user table 에 데이터가 없으면 null 을 return 한다
		if(userList == null || userList.size() < 1) {
			// 데이터가 없으면 최초 가입자 이므로
			// role(권한)을 ADMIN(관리자)로 부여한다
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("USER");
		}
		userDao.insert(userVO);
		return null;
	}

	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		return 0;
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
