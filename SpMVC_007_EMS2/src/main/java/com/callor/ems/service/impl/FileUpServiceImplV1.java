package com.callor.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.ems.service.FileUpService;

public class FileUpServiceImplV1 implements FileUpService {
	
	@Autowired
	private String upPath;

	@Override
	public String fileUp(MultipartFile file) {

		
		return null;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest mFile) {
		// TODO Auto-generated method stub
		return null;
	}

}
