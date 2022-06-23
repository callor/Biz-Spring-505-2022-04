package com.callor.ems.service.impl;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.callor.ems.model.EmsVO;
import com.callor.ems.model.UserVO;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifyConfig.SERVICE.MAIL_V1)
public class SendMailServiceImplV1 implements SendMailService{
	
	/*
	 * 실질적으로 메일을 Naver 통해 전송할 주체
	 */
	protected final JavaMailSender sender;
	public SendMailServiceImplV1(JavaMailSender sender) {
		this.sender = sender;
	}
	
	@Override
	public void sendMail(EmsVO emsVO) {
		
		// mail 전송하기 전에 필수정보에 대해서 확인
		log.debug("받는사람 Email : {}", emsVO.getE_to_email() );
		log.debug("받는사람 이름 : {}", emsVO.getE_to_name() );
		log.debug("제목 : {}", emsVO.getE_subject() );
		
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
			mHelper.setSubject(emsVO.getE_subject());
			
			// 두번째 옵션(true) 본문을 HTML 방식으로 보내기
			mHelper.setText(emsVO.getE_content(),true);
			
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

	@Override
	public void sendMail(EmsVO emsVO, UserVO userVO) {
		// TODO Auto-generated method stub
		
	}

}
