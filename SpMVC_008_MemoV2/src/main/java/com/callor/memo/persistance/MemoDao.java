package com.callor.memo.persistance;

import java.util.List;

import com.callor.memo.model.MemoDTO;

public interface MemoDao {
	
	public List<MemoDTO> selectAll();
	public MemoDTO findById(Long seq);
	public int insert(MemoDTO memo);
	public int update(MemoDTO memo);
	public int delete(Long seq);
	
	public List<MemoDTO> fineByMemo(String memo);
	public List<MemoDTO> findByAuthor(String author);
	
	public void create_memo_table();

	
	
}
