package com.callor.naver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewsVO {
	
	private String title;//	string	개별 검색 결과이며, title, originallink, link, description, pubDate 를 포함한다.
	private String originallink;//	string	검색 결과 문서의 제공 언론사 하이퍼텍스트 link를 나타낸다.
	private String link	;//	string 검색 결과 문서의 제공 네이버 하이퍼텍스트 link를 나타낸다.
	private String description;//	string	검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
	private String pubDate;//	datetime	검색 결과 문서가 네이버에 제공된 시간이다.

}
