package com.callor.hello.controller;

/*
 * 정적(static) 패턴
 * 문자열을 통하여 어떤 것을 구분하는 코드가 필요할때
 * 문자열을 직접사용하면 오타 등으로 인하여 Run time Exception 이 발생할 수 있다
 * Run time Exception 찾기가 어려운 경우가 많다
 * 
 * 미리 클래스.static문자열 형태의 변수를 선언해 두고
 * 필요할때  클래스.static문자열 을 사용하는 것
 * 
 * 코드를 작성과정에서 좀더 빨리 오류를 발견 할 수 있다
 */
public class QualifyConfig {
	
	public final static String HOME_SERVCE_V1 = "homeServiceV1";
	public final static String HOME_SERVCE_V2 = "homeServiceV2";
	public final static String HOME_SERVCE_V3 = "homeServiceV3";

}
