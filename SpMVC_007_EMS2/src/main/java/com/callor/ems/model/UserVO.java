package com.callor.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
public class UserVO {
	
	@Size(min = 5, max = 12,message = "USER NAME 은 5~12글자 까지")
	private String username;
	
//	@Pattern(
//			regexp = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$",
//			message = "비밀번호는 영문 숫자 특수문자 포함 8~15자리 까지"
//	)
	private String password;
	
	@Email(message = "이메일을 정확히 입력해 주세요")
	private String email;
	
	private String name;
	private String role;

	private String key;
	private String key_ok;
	
}
