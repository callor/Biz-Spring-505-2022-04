package com.callor.school.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.school.dao.StudentDao;
import com.callor.school.domain.StudentVO;
import com.callor.school.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService{

	private final StudentDao stDao;
	public StudentServiceImplV1(StudentDao stDao) {
		this.stDao = stDao;
	}
	
	@Override
	public List<StudentVO> selectAll() {
		return stDao.selectAll();
	}

	@Override
	public StudentVO findByStNum(String stNum) {
		// TODO Auto-generated method stub
		return stDao.findByNum(stNum);
	}

	@Override
	public Integer insert(StudentVO stVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(StudentVO stVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(String stNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentVO> findByStTel(String stTel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentVO> findByStName(String stName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentVO> findByStAddr(String stAddr) {
		// TODO Auto-generated method stub
		return null;
	}

}
