package com.callor.memo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoDTO;

public interface MemoService {
	
	public List<MemoDTO> selectAll();
	
	public int insertAndUpdate(MemoDTO memo, MultipartFile file);
	public int delete(Long seq);
	
	public MemoDTO findById(Long seq);

	public List<MemoDTO> findByAuthor(String username);
	

}
