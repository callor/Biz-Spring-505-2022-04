package com.callor.images.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.FilesVO;
import com.callor.images.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.FILE_V2)
public class FileServiceImplV2 implements FileUpService{

	// servlet-context.xml 에 bean 으로 설정된 값을 가져와서
	// upLoadFolder 변수에 담아달라
	private final String upLoadFolder;
	public FileServiceImplV2(String upLoadFolder) {
			this.upLoadFolder = upLoadFolder;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		if(file == null) {
			return null;
		}
		
		File dir = new File(upLoadFolder);
		if( !dir.exists()) {
			dir.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		
		
		/*
		 * 파일 업로드를 할때 원래 파일이름을 그대로 저장하면
		 * 해킹등의 위협에 노출될수 있다
		 * 그래서 파일이름 앞에 UUID 문자열을 첨부하여 파일을 저장하고
		 * 실제 사용자들에게 보여줄때는 원래 이름을 보여주는 식으로 
		 * 코드를 작성해야 한다.
		 */
		// UUID 문자열 생성
		String strUUID = UUID.randomUUID().toString();
		
		fileName = String.format("%s-%s",strUUID, fileName);
		log.debug("변경된 파일이름 {}", fileName);
		
		File upLoadFile = new File(upLoadFolder, fileName);
		file.transferTo(upLoadFile);
		return fileName;
		
	}

	@Override
	public List<FilesVO> filesUp(MultipartHttpServletRequest files) throws Exception {
	
		// 업로드된 여러개의 파일정보를 fileList 에 담기
		List<MultipartFile> fileList = files.getFiles("mFile");
		
		// DB insert 하기 위한 리스트를 만들기위하여 생성
		List<FilesVO> retFiles = new ArrayList<>();
		
		// fileList 를 for() 반복문으로 반복하면서
		// 각각의 파일을 fileUp() 메서드에게 보내서 개별파일을 업로드 수행
		// uuID fileName 을 return 받기
		
		// 원래파일이름과 uuID 가 부착된 파일이름으로 FilesVO를 생성하고
		// retFiles 에 추가하기	
		for(MultipartFile file : fileList) {
			
			String originName = file.getOriginalFilename();
			String uuName = this.fileUp(file);
			
			FilesVO fileVO = FilesVO.builder()
							.i_originalName(originName)
							.i_imageName(uuName)
							.build();
			
			retFiles.add(fileVO);
		}
		return retFiles;
		
	}

	@Override
	public boolean fileDelete(String filename) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
