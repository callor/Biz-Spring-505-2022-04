package com.callor.ems.service;

import com.callor.ems.model.UserVO;
import com.callor.ems.pesistance.UserDao;

public interface UserService extends UserDao {
	
	public int join(UserVO userVO);
	public int join_next(UserVO userVO);

}
