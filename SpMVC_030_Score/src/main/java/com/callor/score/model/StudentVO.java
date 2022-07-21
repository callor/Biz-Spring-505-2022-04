package com.callor.score.model;

import java.util.List;

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
public class StudentVO {

	private String st_num; 		// varchar(5)
	private String st_name;		// varchar(20)
	private String st_dept;		// varchar(20)
	private String st_grade;	// int
	private String st_tel; 		// varchar(15)
	private String st_addr;		// varchar(125)
	
	/*
	 * 학생정보와 성적정보를 같이 묶어서 처리할 경우
	 * 한 학생의 여러 성적을 한꺼번에 관리하기 위하여
	 * 학생정보에 성적리스트 칼럼을 추가한다.
	 */
	private List<ScoreVO> scoreList;

}
