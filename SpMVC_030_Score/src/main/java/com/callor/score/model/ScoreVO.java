package com.callor.score.model;

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
public class ScoreVO {

	private long sc_seq;		// bigint
	private String sc_stnum;	// varchar(5)
	private String sc_sbcode;	// varchar(5)
	private String sc_score;	// int
	
	private String sb_code;
	private String sb_name;

}
