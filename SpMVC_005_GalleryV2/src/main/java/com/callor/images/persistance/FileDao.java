package com.callor.images.persistance;

import java.util.List;

import com.callor.images.model.FilesVO;

public interface FileDao extends GenericDao<FilesVO, Long> {
	
	// 각 게시판 디테일에서 보여줄 이미지 리스트 가져오기
	public List<FilesVO> fineByBBsSeq(long b_seq);

	// 여러개의 파일정보를 table 에 추가하기
	public int insertFiles(List<FilesVO> fileNames);

}
