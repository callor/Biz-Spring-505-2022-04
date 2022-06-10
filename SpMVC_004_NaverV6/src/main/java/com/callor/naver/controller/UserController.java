package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.model.BuyBooksVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.BookService;
import com.callor.naver.service.BuyBooksService;
import com.callor.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	// UserService interface 를 상속받은 어떤 클래스를 주입받겠다 라는 선언
	@Autowired
	@Qualifier(QualifierConfig.SERVICE.USER_V2)
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BuyBooksService buyService;
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("LAYOUT","JOIN");
		return "home";
	}
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		log.debug("회원정보 : {}", userVO.toString());
		
		userService.join(userVO);
		
		
		return "redirect:/user/login";
	}


	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("error",error);
		model.addAttribute("LAYOUT","LOGIN");
		return "home";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(UserVO userVO, Model model, HttpSession session) {
		
		UserVO loginUser = userService.findById(userVO.getUsername());
		if(loginUser == null) {
			model.addAttribute("error","USERNAME_FAIL");
			return "redirect:/user/login";
		}
		loginUser = userService.login(userVO);
		if(loginUser == null) {
			model.addAttribute("error","PASSWORD_FAIL");
			return "redirect:/user/login";
		}
		session.setAttribute("USER", loginUser);
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USER");
		return "redirect:/";
	}
	/*
	 * 매개변수로 설정한 HtpptSession
	 * Controlller 의 각 method 는 Spring 으로 부터 HttpSession 객체를
	 * 주입받을 수 있다
	 * 
	 * HttpSession 객체에는 client 와 server 간에 상태(status)를 유지하는
	 * 정보를 담을 수 있다
	 * 
	 * 여기에 담긴 데이터는 서버가 Run 하는 동안, 일정 조건을 만족하는 동안
	 * Session 제거하지 않는한 계속 메모리에 값이 남아 있다
	 * 
	 * 큰 데이터를 HttpSession에 담는것은 썩 좋지 않다
	 * 최소한으로 status 를 유지할수 있는 데이터만 담는 것이 좋다
	 * 필요가 없어지면 반드시 remove 해주는 것이 좋다
	 * 
	 * 프로젝트의 어떤 method 에서는지 한번 담은 Session정보는
	 * 전체 프로젝트의 Controller method 에서 값을 참조 할수 있다
	 * 
	 * 
	 */
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage(Model model, HttpSession session, String buydate) {
		
		UserVO loginUser = (UserVO) session.getAttribute("USER");
		if(loginUser == null) {
			model.addAttribute("error","LOGIN_NEED");
			return "redirect:/user/login";
		}
		
		// 로그인한 사용자의 도서 구입 리스트 가져오기
		/*
		 * buyBooks 리스트에는 b_isbn, b_username, b_date 값만 담긴 상태이다
		 * 왜, tbl_buybooks 에 3개의 칼럼만 있기 때문에
		 * 이 데이터만 가지고는 구체적인 도서 정보를 알수 없다
		 */
		List<BuyBooksVO> buyBooks = null; 
		if(buydate == null || buydate.isBlank()) {
			buyBooks = buyService.findByUserName(loginUser.getUsername());
		} else {
			buyBooks = buyService.findByUserNameAndDate(loginUser.getUsername(),buydate);
		}

		// 도서 구입리스트의 ISBN 을 도서리스트에서 조회하여 가져오기
		/*
		 * 도서 구입리스트를 for() 문으로 반복하면서
		 * b_isbn 값으로 다시 도서정보를 조회한다
		 * 조회된 도서정보는 book 변수에 담는다
		 * book 변수는 type BookVO 이므로 도서의 구체적인 정보가 담기게 된다
		 */
		for(BuyBooksVO buyVO : buyBooks) {
			String isbn = buyVO.getB_isbn();
			BookVO book = bookService.findById(isbn);
			buyVO.setBook(book);
		}
		
		// 구입한 날짜 리스트
		List<String> buyDates = buyService.findByDate();
		model.addAttribute("BUY_DATES",buyDates);
		model.addAttribute("BUY_BOOKS",buyBooks);
		model.addAttribute("LAYOUT","MYPAGE");
		return "home";
	}
	

	@ResponseBody
	@RequestMapping(value="/idcheck/{username}",method=RequestMethod.GET)
	public String idcheck(@PathVariable("username") String username) {
		
		UserVO userVO = userService.findById(username);
		if(userVO == null) {
			return "OK";
		}
		return "FAIL";
	}
	@ResponseBody
	@RequestMapping(value="/emailcheck",method=RequestMethod.GET)
	public String emailcheck(String email) {
		
		UserVO userVO = userService.findByEmail(email);
		if(userVO == null) {
			return "OK";
		}
		return "FAIL";
	}

	
	
}
