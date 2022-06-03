package com.callor.naver.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.naver.config.NaverConfig;
import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.model.MovieVO;
import com.callor.naver.model.NaverParent;
import com.callor.naver.model.NewsVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.NAVER_V2)
public class NaverServiceImplV2 extends NaverServiceImpl {
	
	@Override
	public String queryString(String cat, String search) {

		String queryString = NaverConfig.NAVER_BOOK_XML_URL;
		String encodeSearch = null;
		try {
			encodeSearch = URLEncoder.encode(search,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("URL Encoding 오류발생");
			return null;
		}
		queryString += String.format("?query=%s", encodeSearch);
		log.debug("Query : " + queryString);
		
		queryString += String.format("&display=%d", 10);
		return queryString;

	}

	@Override
	public List<Object> getNaver(String queryString) {

		URI restURI = null;
		try {
			restURI = new URI(queryString);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			log.debug("URI 문법오류");
			return null;
		}
		
		// Http 프로토콜에 보안 정보를 세팅하여
		// Naver 로 전송할 준비
		HttpHeaders headers = new HttpHeaders();
		headers.set(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
		headers.set(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);

		// JSON 데이터 타입으로 받겠다
		headers.setAccept(
				Collections.singletonList(
						MediaType.APPLICATION_XML));
		
		// headers 에 추가된 정보를 Entity type 의 객체로 변환하기
		HttpEntity<String> entity 
		= new HttpEntity<String>("parameter",headers);
		
		/*
		 * NaverParent 는 List<VO> 타입의 items 변수를 갖는데
		 * 여기에서 VO type 을 BookVO 로 확정지어 준다
		 */
		RestTemplate restTemp = new RestTemplate();

		/*
		 * VO 가 아닌 String 형으로 수신하기
		 */
		ResponseEntity<String> resData = null;
		resData = restTemp.exchange(
				restURI,
				HttpMethod.GET, 
				entity, 
				String.class
				);

		System.out.println("=".repeat(100));
		System.out.println(resData.getBody());
		System.out.println("=".repeat(100));
		
		// return resData.getBody().items;
		return null;
		
	}

}
