package com.callor.ems.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.callor.ems.model.EmsVO;
import com.callor.ems.model.UserVO;
import com.callor.ems.service.QualifyConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifyConfig.SERVICE.MAIL_V2)
public class SendMailServiceImplV2 extends SendMailServiceImplV1 {

	/*
	 * spring 프로젝트에서 
	 * 		src/main/resources 폴더에 저장된 파일들에
	 * 접근하기 위한 보조 도구
	 */
	protected final ResourceLoader loader;
	public SendMailServiceImplV2(JavaMailSender sender, ResourceLoader loader) {
		super(sender); // v1 의 생성자에게 sender 보내기
		this.loader = loader;
	}
	
	@Override
	public void sendMail(EmsVO emsVO,UserVO userVO) {
		
		File htmlFile = null;
		Scanner scan = null;
		try {
			htmlFile = loader.getResource("classpath:mail_template.html").getFile();
			scan = new Scanner(htmlFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// mail 전송하기 전에 필수정보에 대해서 확인
		log.debug("받는사람 Email : {}", emsVO.getE_to_email() );
		log.debug("받는사람 이름 : {}", emsVO.getE_to_name() );
		log.debug("제목 : {}", emsVO.getE_subject() );
		
		
		String uuStr = UUID.randomUUID().toString();
		userVO.setKey_ok(uuStr);
		
		StringBuilder bodyText = new StringBuilder();
		while(scan.hasNext()) {
			String line = scan.nextLine();
			
			line = line.replace("@이름", emsVO.getE_to_name());
			line = line.replace("@email", emsVO.getE_to_email());
			line = line.replace("@key", uuStr);
			bodyText.append(line);
		}
		
		// 메일을 전송하기 위한 Helper Class 가져오기
		// 메일을 보내는 방식을 Mime type 으로 메시지를 만들기
		MimeMessage message = sender.createMimeMessage();
		
		// MimeMessage 에게 속성을 설정하여 주입하기 위한 도구
		MimeMessageHelper mHelper = null;
		
		try {
			/*
			 *  두번째 전달 값
			 *  false : 순수 text 만 전송가능 text/plan type 으로 전송
			 *  true : html 코드를 포함, 첨부파일도 포함 가능, 
			 *  		text/html, multipart/form-data
			 */
			mHelper = new MimeMessageHelper(message,true,"UTF-8");
			mHelper.setFrom("pagenara@naver.com", emsVO.getE_from_name());
			String[] sendTo = {
						emsVO.getE_to_email(),
						"callor@callor.com",
						"callor@daum.net"};
			mHelper.setTo(sendTo);
			mHelper.setSubject("이메일 인증");
			mHelper.setText(bodyText.toString(),true);
			
			// 메일을 보낸다
			sender.send(message);
			log.debug("메일 전송 OK!!");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			log.debug("메시지 생성 오류");
		} catch (UnsupportedEncodingException e) {
			// e.printStackTrace();
			log.debug("메시지 변환 오류");
		}
	}

}
