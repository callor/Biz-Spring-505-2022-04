package com.callor.images.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.BBsVO;
import com.callor.images.persistance.BbsDao;
import com.callor.images.service.FileUpService;

@Service(QualifierConfig.SERVICE.BBS_V1)
public class BbsServiceImplV1 implements BbsDao{

	private final BbsDao bbsDao;
	private final FileUpService fileService;
	
	public BbsServiceImplV1(BbsDao bbsDao, FileUpService fileService) {
		this.bbsDao = bbsDao;
		this.fileService = fileService;
	}

	@Override
	public List<BBsVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BBsVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BBsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BBsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create_bbs_table() {
		// TODO Auto-generated method stub
		
	}

	
	
}
