package com.callor.score.service;

import com.callor.score.model.ScoreUpdateVO;
import com.callor.score.persistance.ScoreDao;

public interface ScoreService extends ScoreDao{
	
	public int updateScore(String st_num, String[] sb_code, String[] sc_score);
	public int updateScore(ScoreUpdateVO score);

}
