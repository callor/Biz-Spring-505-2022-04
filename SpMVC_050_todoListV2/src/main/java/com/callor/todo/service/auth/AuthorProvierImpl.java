package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

@Service("authenticationProvider")
public class AuthorProvierImpl implements AuthenticationProvider{
	
	@Autowired
	private UserDao userDao;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// getPrincipal().toString(), getCredentials().toString() 형식으로
		// 사용할수 있지만 null pointer exception 이 발생할 수 있어서
		// 문자열 형변환을 사용한다
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		UserVO userVO = userDao.findById(username);
		if(userVO == null) {
			throw new UsernameNotFoundException(username + " 은 회원가입 하세요");
		}
		
		if(userVO.getPassword().equals(password)) {
			throw new BadCredentialsException("비밀번호 오류");
		}
		
		List<AuthorityVO> authList = userDao.select_role(username);
		List<GrantedAuthority> grantList = new ArrayList<>();
		for(AuthorityVO vo : authList) {
			grantList.add(new SimpleGrantedAuthority(vo.getAuthority()));
		}
		userVO.setAuthorities(grantList);
		
		// 사용자 이름과 비번, 권한리스트로 Token 발행
		UsernamePasswordAuthenticationToken token
		= new UsernamePasswordAuthenticationToken(userVO,null,grantList);
		return token;
		
	}

	/*
	 * security에서 인증절차를 수행하기 위하여 AuthenticationProvider 를 
	 * 상속받으면 반드시 supports 를 true 로 만들어 주어야 한다
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
