package com.callor.sec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.sec.model.AuthorityVO;
import com.callor.sec.model.UserVO;
import com.callor.sec.psersistance.UserDao;
import com.callor.sec.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImplV1 implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;
		 

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
		return userDao.selectAll();
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
		
		// vo 에 담긴 평문 password 를 BCrypt 암호화 방식으로 암호화 처리
		String encPassword = passwordEncoder.encode(vo.getPassword());
		// 암호화된 password 를 다시 vo 에 저장
		vo.setPassword(encPassword);
		
		userDao.roleInsert(authList);
		return userDao.insert(vo);
		
	}

	/*
	 * Security 에서 Update 수행하기
	 * 1. 사용자 정보를 findById() 해서 가져오고
	 * 2. DB 에 저장된 비밀번호와 입력한 비밀번호가 일치하는 확인
	 * 		만약 일치하지 않으면 되돌려 보내기
	 * 3. 일치한다면 update 수행
	 */
	@Override
	public int update(UserVO vo) {

		log.debug("Update {}",vo);
		
		// 사용자 정보 db에서 가져오기
		UserVO getUser = userDao.findById(vo.getUsername());
		log.debug("Get User {}",getUser);
		
		
		// 비밀번호 일치 확인
		if(passwordEncoder.matches(vo.getPassword(), getUser.getPassword()) == false) {
			return -1;
		}
		
		// 비밀번호를 변경하지 않도록 하기 위하여
		// DB 에서 가져온 비밀번호로 다시 세팅
		vo.setPassword(getUser.getPassword());
		int ret = userDao.update(vo);
		
		// 로그인된 사용자의 로그인 정보를 갱신하기
		
		// 1. 현재 로그인된 정보를 get
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// 2. 정보에서 Role 정보를 수집하고
		List<GrantedAuthority> grantList = new ArrayList<>(auth.getAuthorities());

		// 3. 새로운 로그인 정보를 생성
		Authentication newAuth 
			= new UsernamePasswordAuthenticationToken(vo,null, grantList);
		
		// 4. SecurityContext 에 Update 하기
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		return ret;
		
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

	@Override
	public List<AuthorityVO> roleSelect(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
