package com.callor.hello.persistance;

import java.util.List;

import com.callor.hello.model.AddressVO;

public interface AddressDao {
	
	public List<AddressVO> selectAll();
	public AddressVO findById(long seq);
	
	public int insert(AddressVO vo);
	public int update(AddressVO vo);
	public int delete(long seq);
	
	public List<AddressVO> findByName(String name);
	public List<AddressVO> findByTel(String tel);
	public List<AddressVO> findByAddr(String addr);
	
}
