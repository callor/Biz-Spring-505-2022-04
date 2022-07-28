package com.callor.sec.psersistance;

import com.callor.sec.model.UserVO;

public interface UserDao extends GenricDao<UserVO, String>{
	
	public void create_uesr_table();
	public void create_author_table();

}
