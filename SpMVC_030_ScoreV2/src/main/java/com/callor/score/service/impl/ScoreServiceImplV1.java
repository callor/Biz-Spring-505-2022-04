package com.callor.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.service.ScoreService;

@Service
public class ScoreServiceImplV1 implements ScoreService{

	@Autowired
	private ScoreDao scoreDao;
	
	@Override
	public List<ScoreVO> findByStNum(String sc_stnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateScore(String st_num, String sb_code, String sc_score) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateScore(String st_num, String[] sb_code, String[] sc_score) {

		int ret = 0;
		for(int i = 0 ; i < sb_code.length ; i++) {
			ret += scoreDao.updateScore(st_num, sb_code[i], sc_score[i]);
		}
		return ret;
	}

}
