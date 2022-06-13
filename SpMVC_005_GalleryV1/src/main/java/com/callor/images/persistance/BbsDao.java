package com.callor.images.persistance;

import com.callor.images.model.BBsVO;

public interface BbsDao extends GenericDao<BBsVO, Long>{
	
	public void create_bbs_table();
	
}
