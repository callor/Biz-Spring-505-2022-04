package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoDTO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.FileUpService;
import com.callor.memo.service.MemoService;

@Service
public class MemoServiceImplV1 implements MemoService{

	protected final FileUpService fileUp;
	protected final MemoDao memoDao;
	
	public MemoServiceImplV1(FileUpService fileUp,MemoDao memoDao) {
		this.fileUp = fileUp;
		this.memoDao = memoDao;
	}
	
	@Autowired
	public void create_table() {
		memoDao.create_memo_table();
	}
		
	@Override
	public List<MemoDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertAndUpdate(MemoDTO memo, MultipartFile file) {
		// TODO Auto-generated method stub
		// insert(새로추가)가 되는 경우는 m_seq 가 0 일 것이고
		// Update(수정)가 되는 경우는 m_seq 가 0 이 아닐 것이다
		long m_seq = memo.getM_seq();
		
		// 메모 수정일 경우 처리
		if(m_seq != 0) {
			// 먼저 seq 값으로 table 에서 데이터를 가져오고
			MemoDTO updateMemo = memoDao.findById(m_seq);
			
			// 저장된 파일 이름을 가져오기
			String fileName = updateMemo.getM_image();
			
			// 저장된 파일 이름과 새롭게 업로드된 파일 이름이 다르면
			if( !fileName.equals(file.getOriginalFilename() ) ) {
				// 기존의 파일을 삭제하고
				fileUp.fileDelete(updateMemo.getM_up_image());
			}
		
			// 파일을 업로드 하고
			// 업로드된 파일 이름 가져오기
			String upLoadFileName = fileUp.fileUp(file);
			
			// table 에 저장하기 위하여
			// 원래 파일 이름과 UUID 가 부착된 파일이름을 DTO 에 저장
			memo.setM_image(file.getOriginalFilename());
			memo.setM_up_image(upLoadFileName);
			return memoDao.update(memo);
		}
		
		memo.setM_image(file.getOriginalFilename());
		memo.setM_up_image(fileUp.fileUp(file));
		return memoDao.insert(memo);
	
	}

	/*
	 * 메모를 삭제할때
	 * 1. 첨파일이 있을 경우 파일을 먼저 삭제 해야 한다
	 * 2. 데이터를 삭제 한다.
	 * 
	 * 만약 순서가 바뀌게 되면, 필요없는 파일들이
	 * 폴더에 남아 있을 수 있다.
	 * 
	 */
	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		
		// seq 에 해당하는 데이터를 select 하고
		MemoDTO memo = memoDao.findById(seq);
		
		// 파일이름을 fileDelete() method 에게 보내서
		// 파일을 삭제
		fileUp.fileDelete(memo.getM_up_image());
		
		// 데이터 삭제
		memoDao.delete(seq);
		return 0;
	}

	@Override
	public MemoDTO findById(Long seq) {
		// TODO Auto-generated method stub
		return memoDao.findById(seq);
	}

	@Override
	public List<MemoDTO> findByAuthor(String username) {
		return memoDao.findByAuthor(username);
	}

}
