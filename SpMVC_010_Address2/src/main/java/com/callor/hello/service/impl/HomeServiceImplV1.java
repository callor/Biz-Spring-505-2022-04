package com.callor.hello.service.impl;

import org.springframework.stereotype.Service;

import com.callor.hello.controller.QualifyConfig;
import com.callor.hello.model.AddressVO;
import com.callor.hello.service.HomeService;

/*
 * 프로젝트에서 공통으로 사용할 인터페이스를 미리 정의한후
 * 인페이스를 implements 하여 클래스를 작성하면
 * 공통으로 사용하는 기능의 이름이 통일되고, 사용하는 곳에서는
 * 다음 코드를 변경하더라도 본인의 코드를 최소한으로 변경하면
 * 기능을 업그레이드 할수 있다
 */
@Service(QualifyConfig.HOME_SERVCE_V1)
public class HomeServiceImplV1 implements HomeService{

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String goodBye() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String goodBye(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(String ad_name, String ad_tel, String ad_addr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(AddressVO address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AddressVO findByName(String ad_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
