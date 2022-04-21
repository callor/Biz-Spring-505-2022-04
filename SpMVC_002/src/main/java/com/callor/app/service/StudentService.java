package com.callor.app.service;

import com.callor.app.domain.StudentVO;

public interface StudentService {
	
	public int insert(StudentVO studentVO);
	public StudentVO[] selectAll();
	public StudentVO findById(String stNum);
	

}
