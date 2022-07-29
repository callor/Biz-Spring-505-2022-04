package com.callor.sec.service.auth;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

/*
 * 현재 UserDetailsService 와 AuthorProvider 에서 
 * 인증을 실행하는 중간에 문제가 생기면
 * == 문제 : username 이 table 에 없거나, password 가 틀렸거나
 * 	 	enabled 칼럼의 값이 false 이거나
 * exception 을 강제로 발생시켰다
 * 이 exception 을 custom 하여 exception 과정에서 만들어진 message 를
 * login 화면에 보여주는 일을 수행한다.
 */

@Service("authorFailurHander")
public class AuthorFailHanderImpl extends SimpleUrlAuthenticationFailureHandler{

	/*
	 * 인증과정에서 exception 이 발생하면 처리할 이벤트 핸들러
	 */
	@Override
	public void onAuthenticationFailure(
			HttpServletRequest request, 
			HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

			String exceptionMessage = "";
			String redirectURL = "/user/login?exception=%s";
			if(exception instanceof BadCredentialsException) {
				exceptionMessage = exception.getMessage();
			} else if(exception instanceof UsernameNotFoundException) {
				exceptionMessage = "로그인을 위하여 회원가입을 해 주세요";
				redirectURL = "/user/join?exception=%s";
			}
		
			exceptionMessage = URLEncoder.encode(exceptionMessage,"UTF-8");
			redirectURL = String.format(redirectURL, exceptionMessage);
			
			// redirect를 수행하는 method
			setDefaultFailureUrl(redirectURL);
		
			super.onAuthenticationFailure(request, response, exception);
	}

	
	
	
}
