package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

/*
 * Spring security 에서 지원하는 UserDetailsService 를 상속받아
 * 클래스를 작성한다
 */
@Service("userDetailsService")
public class UserDetailsServiceImplV1 implements UserDetailsService{

	private final UserDao userDao;
	public UserDetailsServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}



	/*
	 * DB 로 부터 사용자 정보를 SELECT 하여 사용자 정보가 있는지 검사
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserVO userVO = userDao.findById(username);

		/*
		 * 사용자 정보가 DB 없으면 
		 * exception 을 발생시켜서 Security 에게 알리기
		 */
		if(userVO == null) {
			throw new UsernameNotFoundException(username + " : 회원가입을 먼저 하세요");
		}

		
		List<AuthorVO> authos = userDao.select_auths(username);
		
		if(authos.size() < 1) {
			throw new UsernameNotFoundException(
					String.format("[ %s ] 아무런 권한이 없습니다", username));
		}
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		// 사용자의 권한정보를 문자열에서 GrantedAuthority 객체로 변환하기
		for(AuthorVO auth : authos) {
			grantList.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}

		// GrantedAuthority 객체 변환된 ROLE 정보를 
		// 사용자 정보에 setting
		userVO.setAuthorities(grantList);
		return userVO;
	}

}
