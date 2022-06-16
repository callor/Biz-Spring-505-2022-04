package com.callor.images.persistance;

import java.util.List;

import com.callor.images.model.ImagesVO;

public interface FileDao extends GenericDao<ImagesVO, Long> {
	
	// 각 게시판 디테일에서 보여줄 이미지 리스트 가져오기
	public List<ImagesVO> fineByBBsSeq(long b_seq);

}
