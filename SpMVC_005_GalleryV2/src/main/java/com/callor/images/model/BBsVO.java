package com.callor.images.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BBsVO {
	
	private long b_seq;
	private String b_date;
	private String b_time;
	private String b_writer;
	private String b_subject;
	private String b_content;
	
	private List<FilesVO> images;

}
