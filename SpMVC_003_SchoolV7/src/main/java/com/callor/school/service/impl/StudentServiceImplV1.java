package com.callor.school.service.impl;

import java.util.List;

import com.callor.school.model.StudentVO;
import com.callor.school.pesistance.StudentDao;
import com.callor.school.service.StudentService;

public class StudentServiceImplV1 implements StudentService{
	
	private final StudentDao stDao;
	public StudentServiceImplV1(StudentDao stDao) {
		this.stDao = stDao;
	}

	public List<StudentVO> selectAll() {
		List<StudentVO> stList = stDao.selectAll();
		return stList;
	}

	@Override
	public StudentVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
