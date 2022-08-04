package com.callor.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.callor.todo.model.AuthorVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;
import com.callor.todo.service.UserService;

@Service("userServiceV1")
public class UserServiceImplV1 implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void create_user_table() {
		userDao.create_user_table();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create_auth_table() {
		userDao.create_auth_table();
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AuthorVO> select_auths(String username) {
		// TODO Auto-generated method stub
		return null;
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

	/*
	 * Transaction 이 필요한곳에 Annotation 을 부착해 두면
	 * Transaction 자동으로 적용된다.
	 */
	@Transactional
	@Override
	public int insert(UserVO vo) {

		List<UserVO> users = userDao.selectAll();
		List<AuthorVO> auths = new ArrayList<>();

		/*
		 * 최초에 회원가입이 되면 ADMIN 권한을 부여하고
		 * 그렇지 않으면 일반 USER 권한을 부여한다.
		 */
		if(users == null || users.size() < 1) {
			vo.setEnabled(true);
			auths.add(AuthorVO.builder().username(vo.getUsername())
				.authority("ROLE_ADMIN").build());
			auths.add(AuthorVO.builder().username(vo.getUsername())
					.authority("ROLE_USER").build());
		} else {
			auths.add(AuthorVO.builder().username(vo.getUsername())
					.authority("ROLE_USER").build());
		
		}
		
		// BCrypt 클래스를 사용하여 비번 암호화 하기
		String encPassword = passwordEncoder.encode(vo.getPassword());
		vo.setPassword(encPassword);
		userDao.role_insert(auths);
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
	public int role_insert(List<AuthorVO> auths) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/*
	 * Controller 가 아닌 Service 등의 클래스에서
	 * 로그인 정보를 추출하는 방법
	 */
	public void getLoginUser() {
		Authentication auth = SecurityContextHolder
							.getContext()
							.getAuthentication();
		UserVO userVO = (UserVO) auth.getPrincipal();
	}
	

}
