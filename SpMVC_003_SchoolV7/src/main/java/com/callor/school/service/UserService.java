package com.callor.school.service;

import com.callor.school.model.UserVO;

public interface UserService {
	
	public UserVO login(UserVO userVO);
	public UserVO join(UserVO userVO);

}
