package com.callor.sec.psersistance;

import java.util.List;

import com.callor.sec.model.AuthorityVO;
import com.callor.sec.model.UserVO;

public interface UserDao extends GenricDao<UserVO, String>{
	
	public void create_uesr_table();
	public void create_author_table();
	public int roleInsert(List<AuthorityVO> authList);
	
	public List<AuthorityVO> roleSelect(String username);
	

}
	