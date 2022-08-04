package com.callor.todo.persistance;

import com.callor.todo.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String> {

	public void create_user_table();
	public void create_auth_table();
	
}
