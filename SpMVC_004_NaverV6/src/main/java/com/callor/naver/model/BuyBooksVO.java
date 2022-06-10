package com.callor.naver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyBooksVO {
	
	private String b_isbn;
	private String b_username;
	private String b_date;
	
	private BookVO book;
	private UserVO user;

}
