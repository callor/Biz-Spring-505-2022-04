package com.callor.score.persistance;

import java.util.List;

import com.callor.score.model.ScoreVO;

public interface ScoreDao extends GenericDao<ScoreVO, String>{

	public List<ScoreVO> findByStNum(String sc_stnum);
	
}
