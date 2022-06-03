package com.callor.naver.model;

import java.util.List;
public class NaverXMLParent<VO> {
	
	public List<Object> items;	//	-	XML 포멧에서는 item 태그로, JSON 포멧에서는 items 속성으로 표현된다. 개별 검색 결과이며 title, link, description을 포함한다.

}
