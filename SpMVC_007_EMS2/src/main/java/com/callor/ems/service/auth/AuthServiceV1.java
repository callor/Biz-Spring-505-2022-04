package com.callor.ems.service.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Spring 3.x 이상 부터 사용하는 xml 을 대신하는 선언 클래스
 * @Configuration : context.xml 을 java class 로 선언한다 라는 의미
 */
@Configuration
public class AuthServiceV1 {

	/*
	 * context.xml 에서 <bean>으로 선언하는 문장을 대신
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder(4);
		return encoder;
	}

}
