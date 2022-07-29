package com.callor.sec.service.auth;

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

import com.callor.sec.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authenticationProvider")
public class AuthorProviderImpl implements AuthenticationProvider{

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDeService;
	
	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		/*
		 * Authentication 
		 * 로그인한 사용자의 정보를 전달받을 객체
		 * username password 를 통항 login 절차
		 * Principal Credentials 방식의 로그인
		 */
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		
		UserVO user = (UserVO) userDeService.loadUserByUsername(username);
		
		// 사용자의 비밀번호 검사 등을 실행하여 정상 접근인지 확인하기
		if(passwordEncoder.matches(password,user.getPassword()) == false) {
			throw new BadCredentialsException("* 비밀번호 오류");
		}
		
		// 최초 회원가입을 했을때는 아직 정상 절차가 완료되지 않아서
		// 로그인을 성공해도 다른 기능을 사용할수 없도록 하기 위하여
		// 회원데이터의 isEnable 값을 false 로 설정하고
		// 이후 다른 절차를 통하여 정상 사용자 임이 입증되면
		// isEnabled 칼럼을 true 하여 사용을 인가하는 절차를 진행한다
		if(user.isEnabled() == false) {
			throw new BadCredentialsException(username + " : 회원가입 절차가 마무리 되지 않아 사용할수 없음" );
		}
		log.debug("인증클래스");
		
		// 인증이 완료되면 사용자 정보를 Security.Context token 과 함께 담아서
		// 로그인 성공을 프로젝트에 전파하기 위하여 객체로 구현
		// user : 로그인한 사용자 정보,
		// user.getAuthorities() : 로그인한 사용자의 권한 리스트
		Authentication authorOk 
		= new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
		return authorOk;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
