package com.callor.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.todo.persistance.UserDao;

@Service
public class BeanServiceImpl {
	
	@Autowired	
	private UserDao userDao;
	
	/*
	 * XML 이 아닌 Java class 에서 Bean 생성하기
	 */
	@Bean("passwordEncoder")
	public PasswordEncoder getPassword() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * UserServiceImpl 에서 table 을 생성하는 SQL 호출하면
	 * @Transaction 과 충돌하는 현상이 발생하여
	 * 별도 클래스로 method 를 분리했다
	 */
	@Bean
	public void create_table() {
		userDao.create_auth_table();
		userDao.create_user_table();
	}

	

}
