package com.callor.images.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * DTO 와 VO
 * DTO(Data Transfer Object) : 데이터를 담아서 이동하는 용도
 * 		-  JOIN 등으로 만들어진 결과 데이터를 담는 용도
 * VO(Value Object) : 데이터와 연산을 포함하는 용도
 * 		- Controller 에서 매개변수로 사용하기
 * 		- 일부 getter() method 에 결과를 연산하는 코드를 추가
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class WorkOutDTO {
	
	private String sl_id;//	varchar2(5)
	private String sl_scid;//	varchar2(4)
	private String sc_num;//	varchar2(6)
	private String sc_label;//	nvarchar2(10)
	private String sc_division;//	nvarchar2(20)
	private String sc_day;//	varchar2(10)
	private String sc_part;//	nvarchar2(30)
	private String sl_listid;//	varchar2(5)
	private String list_name;//	nvarchar2(125)
	
	private int sl_set;
	private String sl_weight;
	private String sl_rep;
	
	
}
