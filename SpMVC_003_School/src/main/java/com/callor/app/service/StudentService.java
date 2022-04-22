package com.callor.app.service;

import java.util.List;

import com.callor.app.domain.StudentVO;

public interface StudentService {
	
	public int insert(StudentVO studentVO);
	public List<StudentVO> selectAll();
	public StudentVO findById(String stNum);
	

}
