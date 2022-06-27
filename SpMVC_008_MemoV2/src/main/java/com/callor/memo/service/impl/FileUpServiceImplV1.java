package com.callor.memo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.service.FileUpService;

@Service
public class FileUpServiceImplV1 implements FileUpService{

	/*
	 * servlet-context.xml 에 선언된 문자열 변수 값 연결하기
	 */
	@Autowired
	@Qualifier("upLoadFolder")
	protected String upLoadFolder;
	
	@Override
	public String fileUp(MultipartFile file) {

		// 파일 정보가 없으면 더이상 진행하지 말기
		if(file == null) {
			return null;
		}
		
		// 저장할 폴더 확인하기
		// java.io.File import
		File dir = new File(upLoadFolder);
		// 업로드할 폴더가 없으면
		if( dir.exists() == false) {
			// 폴더를 만들어라
			dir.mkdirs();
		}
		
		// 업로드된 파일의 이름 getter
		String originFileName = file.getOriginalFilename();
		
		// 해킹을 방지하기 위하여 파일 이름 변경하기
		// 1. UUID 문자열 생성
		String uuStr = UUID.randomUUID().toString();

		// 원래 파일이름과 UUID 를 합성하여 새로운 파일 이름 지정하기
		String saveFileName = String.format("%s-%s",uuStr,originFileName);

		// 서버에 저장하기 위한 파일 객체 생성
		File saveFile = new File(upLoadFolder, saveFileName);
		
		try {
			file.transferTo(saveFile);
			return saveFileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fileDelete(String fileName) {
		
		if(fileName == null) {
			return;
		}
		
		// 업로드 폴더와 파일이름묶어 파일 객체 생성
		File deleteFile = new File(upLoadFolder, fileName);
		
		// 실제 파일이 존재하는 확인하고
		if(deleteFile.exists()) {
			// 존재하면 파일을 삭제
			deleteFile.delete();
		}
		
	}

}
