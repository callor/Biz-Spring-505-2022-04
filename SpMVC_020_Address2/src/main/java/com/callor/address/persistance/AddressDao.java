package com.callor.address.persistance;

import java.util.List;

import com.callor.address.model.AddressVO;

public interface AddressDao {
	
	
	public void create_addr_table();
	public List<AddressVO> selectAll();
	public AddressVO findById(long a_seq);
	public int insert(AddressVO address);
	public int update(AddressVO address);
	public int delete(long a_seq);

}
