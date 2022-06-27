package com.callor.memo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * DTO : Data Transfer Object
 * 역할은 VO 와 같다
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemoDTO {
	private long m_seq;
	private String m_author;
	private String m_date;
	private String m_time;
	private String m_memo;
	private String m_image;
	
	private String m_up_image;
	
}
