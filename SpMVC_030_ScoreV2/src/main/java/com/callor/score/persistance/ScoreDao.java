package com.callor.score.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.score.model.ScoreUpdateVO;
import com.callor.score.model.ScoreVO;

public interface ScoreDao extends GenericDao<ScoreVO, String>{

	public List<ScoreVO> findByStNum(String sc_stnum);
	
	public int updateScore(ScoreUpdateVO score);
	
	public int updateScoreArray(
			@Param("st_num")
			String st_num, 

			@Param("sb_code")
			String sb_code, 

			@Param("sc_score")
			String sc_score);
	
}
