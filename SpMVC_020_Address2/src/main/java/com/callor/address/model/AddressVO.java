package com.callor.address.model;

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
public class AddressVO {

	private long a_seq;
	private String a_name;
	private String a_tel;
	private String a_address;
	
}
