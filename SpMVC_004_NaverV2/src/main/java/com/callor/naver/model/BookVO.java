package com.callor.naver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * naver 도서검색 결과를 담을 VO 클래스 선언
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookVO {
	private String title;	//	string	검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
	private String link;	//	string	검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
	private String image;	//	string	썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타납난다.
	private String author;	//	string	저자 정보이다.
	private String price;	//	integer	정가 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
	private String discount;//	integer	할인 가격 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
	private String publisher;//	string	출판사 정보이다.
	private String isbn;	//	integer	ISBN 넘버이다.
	private String description;//	string	검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
	private String pubdate;	//	datetime	출간일 정보이다.
}
