package com.callor.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.todo.model.UserVO;

@Service("authenticationProvider")
public class AuthenticationProviderImpl  implements AuthenticationProvider{

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		// UserDetailsService 에서 username 은 조회를 하여
		// DB table 로 부터 가져온 user 정보를 user 객체에 받기
		// 만약 username 에 해당하는 데이터가 없으면
		// UserDetailsService에서 exception 발생하므로
		// 더 이상의 절차없이 다시 로그인 화면으로 돌아간다
		UserVO user = (UserVO) userService.loadUserByUsername(username);
		
		// 입력된 비밀번호와 DB 로 부터 SELECT 한 비밀번호를
		// PasswordEncoder 를 사용하여 비교
		if(passwordEncoder.matches(password,user.getPassword()) == false) {
			// Password 가 일치하지 않으면
			// Exception 을 발생시켜 Security 에게  알린다
			throw new BadCredentialsException("비밀번호가 잘못되었습니다");
		}
		
		// 회원가입 후에 enabled 칼럼을 기본값으로 false 하고
		// 관리자일 경우만 자동으로 true 로 하여 일반사용자는
		// 관리자 승인이 있어야만 로그인이 되도록 하는 절치
		if(user.isEnabled() == false) {
			throw new BadCredentialsException(
					username + " 은 회원가입절차가 완료되지 않음");
		}
		
		// 정상적으로 사용자가 로그인하면
		// 인증 token
		UsernamePasswordAuthenticationToken
			token = new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
