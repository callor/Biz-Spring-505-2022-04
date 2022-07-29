package com.callor.sec.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Security 에서 제공하는 사용자 정보를 담을 VO 를 생성한다
 * 여기서 UserDetails 인터페이스를 상속받아 사용한다
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserVO implements UserDetails  {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	
	private Collection<? extends GrantedAuthority> authorities; // getAuthorities
	
	private String email;
	private String tel;
	private String realname;
	private String nickname;

}
