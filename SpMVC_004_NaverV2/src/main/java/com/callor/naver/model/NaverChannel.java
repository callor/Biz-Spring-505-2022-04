package com.callor.naver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.ToString;

@ToString
@JacksonXmlRootElement(localName = "rss")
/*
 * xml 파일을 parsing 하여 객체에 담을때
 * xml tag 에는 있는데 클래스에 변수가 선언되지 않았을때
 * 그러한 변수를 만나면 무시하라
 * 
 * 이 속성은 일단 모든 변수가 선언된 클래스를 선언하여
 * 테스트를 마무리하고
 * 필요없는 변수들을 제거하고 사용하라
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverChannel {
	
//	public String version;
	
	@JacksonXmlProperty(localName = "channel")
	public NaverXMLParent channel;

}
