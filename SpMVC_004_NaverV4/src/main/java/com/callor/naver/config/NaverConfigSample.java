package com.callor.naver.config;

/*
 * Naver 개발자센터에 등록하고
 * 애플리케이션을 생성하여 부여된 ID와 SEC 를
 * 다음의 변수에 작성하고 이 클래스를 NaverConfig 이름으로
 * 변경한 후 프로젝트를 실행하시오
 */
public class NaverConfigSample {
	
	public static final String NAVER_CLIENT_ID = "";
	public static final String NAVER_CLIENT_SEC = ""; 
	
	public static class HEADER {
		public static final String ID = "X-Naver-Client-Id";
		public static final String SEC = "X-Naver-Client-Secret";
	}
	
	public static final String NAVER_BOOK_URL = "https://openapi.naver.com/v1/search/book.json";
	public static final String NAVER_BOOK_XML_URL = "https://openapi.naver.com/v1/search/book.xml";
	public static final String NAVER_NEWS_URL = "https://openapi.naver.com/v1/search/news.json";
	public static final String NAVER_MOVIE_URL = "https://openapi.naver.com/";

	public static final String APP_JSON = "application/json;charset=UTF-8";

}
