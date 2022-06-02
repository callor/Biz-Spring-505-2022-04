package com.callor.naver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieVO {
	
	private String title;//	string	검색 결과 영화의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
	private String link;//	string	검색 결과 영화의 하이퍼텍스트 link를 나타낸다.
	private String image;//	string	검색 결과 영화의 썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타난다.
	private String subtitle;//	string	검색 결과 영화의 영문 제목이다.
	private String pubDate;//	date	검색 결과 영화의 제작년도이다.
	private String director;//	string	검색 결과 영화의 감독이다.
	private String actor;//	string	검색 결과 영화의 출연 배우이다.
	private String userRating;//	integer	검색 결과 영화에 대한 유저들의 평점이다.

}
