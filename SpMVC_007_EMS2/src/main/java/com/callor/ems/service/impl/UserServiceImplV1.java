package com.callor.ems.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.ems.model.EmsVO;
import com.callor.ems.model.UserVO;
import com.callor.ems.pesistance.UserDao;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;
import com.callor.ems.service.UserService;


@Service
public class UserServiceImplV1 implements UserService{
	
	@Autowired
	private PasswordEncoder passEnc;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier(QualifyConfig.SERVICE.MAIL_V3)
	private SendMailService xMail;

	/*
	 * 
	 * 테이블을 자체적으로 생성한 method 를 자동 호출하여 실행한다
	 * 생성자에서 테이블을 만들 수도 있지만 별도의 method 를 선언하여 실행한다
	 * 
	 * 생성자에서 method 를 호출하여 어떤 연산을 수행하는 것은
	 * 성능상의 이슈가 있다고 한다
	 * 생성자에서는 가급적 변수, 객체를 초기화하는 코드만 두고
	 * 기타 활동은 별도의 method 에서 수행하는 것이 좋다 라고 한다.
	 * 
	 */
	@Autowired
	@Override
	public void create_user_table() {
		userDao.create_user_table();
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
		// TODO Auto-generated method stub
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

	@Override
	public int join(UserVO userVO) {

		// 인증할 Email 주소를 username 에 setting
		
		String encEmail = UUID.randomUUID().toString();
		String email = userVO.getEmail();
		
		userVO.setUsername(encEmail);
		userVO.setPassword("1111");
		userVO.setRole("GUEST");
		userDao.insert(userVO);
		
		EmsVO emsVO = EmsVO.builder().e_to_email(email).build();
		xMail.sendMail(emsVO,userVO);
		return 0;
		
	}

	@Override
	public int join_next(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
