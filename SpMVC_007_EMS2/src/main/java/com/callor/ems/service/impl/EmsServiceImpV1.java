package com.callor.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.ems.model.EmsVO;
import com.callor.ems.pesistance.EmsDao;
import com.callor.ems.service.EmsService;

@Service
public class EmsServiceImpV1 implements EmsService {

	private final EmsDao emsDao;
	public EmsServiceImpV1(EmsDao emsDao) {
		this.emsDao = emsDao;
	}

	@Autowired
	@Override
	public void create_ems_table() {
		emsDao.create_ems_table();
	}

	@Override
	public List<EmsVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmsVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(EmsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(EmsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
