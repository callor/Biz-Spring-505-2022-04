package com.callor.ems.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.callor.ems.model.EmsVO;
import com.callor.ems.model.UserVO;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
@SessionAttributes("userVO")
public class UserController {
	
	@Autowired
	@Qualifier(QualifyConfig.SERVICE.MAIL_V2)
	private SendMailService xMail;
	
	/*
	 * UserVO 를 ModelAttribute로 생성하여 join.jsp 에게 보내기
	 * UserVO userVO = new UserVO(); 코드를 대신 실행한다
	 * 
	 * ModelAttribute 로 생성된 userVO 는
	 * SessionAttributes 에 추가되어 보관된다
	 * 
	 */
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserVO userVO,Model model) {
		model.addAttribute("userVO",userVO);
		return null;
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@Valid UserVO userVO, BindingResult result) {
	
		// email 형식 유효성 검사를 통과하지 못하면 다시 join.jsp 에게 
		// 되돌려 보낸다
		if(result.hasErrors()) {
			return null;
		}
		
		// 유효성 검사를 통과하면 인증메일을 보내기 위해
		// EmsVO 객체를 생성한다
		EmsVO emsVO = EmsVO.builder()
						.e_to_email(userVO.getEmail())
						.e_to_name("새로운 회원")
						.build();
		
		// 인증 메일을 보내고
		xMail.sendMail(emsVO,userVO);
		
		// 인증메일을 보내고 나면 userVO 의 key_ok 변수에는
		// 인증 키가 담겨있는 상태가 된다.
		return "redirect:/user/join_next";
	}
	
	/*
	 * ModelAttribute userVO 코드를 만나면
	 * 일단 클라이언트에서 전송되어 userVO 에 담긴 데이터가 있는지 확인한다
	 * 데이터가 있으면 그대로 통과를 하고
	 * 만약 데이터가 없으면 SessionAttribute 에 보관중인 userVO 데이터를 가져와서
	 * 매개변수 userVO 에 세팅한다
	 */
	@RequestMapping(value="/join_next",method=RequestMethod.GET)
	public String join_next(
			@ModelAttribute("userVO") UserVO userVO, 
			String error,
			Model model) {
		
		model.addAttribute("error",error);
		return null;
	}

	@RequestMapping(value="/join_next",method=RequestMethod.POST)
	public String join_next(
			@Valid @ModelAttribute("userVO") UserVO userVO,
			BindingResult result, 
			Model model,
			SessionStatus sessionStatus) {
		
//		if(result.hasErrors()) {
//			return null;
//		}
		if(userVO.getKey().equals(userVO.getKey_ok())) {
			log.debug("인증키 확인 성공");
			/*
			 * SessionAttribute 에 담아두었던 데이터를
			 * 모두 사용하였으면 데이터를 소멸 시켜줘야 한다
			 */
			sessionStatus.setComplete();
			return "redirect:/user/join_ok";
		} else {
			log.debug("인증키가 다름");
			return "redirect:/user/join_next?error=key";
		}
	}

	
	/*
	 * 어디선가 UserVO uesrVO 객체가 필요하면
	 * 자동으로 객체를 생성하여 return 하는 코드가 실행된다
	 */
	@ModelAttribute("userVO")
	private UserVO userVO() {
		return new UserVO();
	}

}




