package com.callor.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/books")
public class BooksController {
	
	@Qualifier(QualifierConfig.SERVICE.BOOKS_V1) 
	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	// localhost:8080/naverr/books 라고 요청하기
	@RequestMapping(value={"/",""}  )
	public String home() {
		/*
		 * return "문자열" 형식은
		 * 명시적으로 어떤 jsp 파일을 rendering 할 것인지
		 * 알려주는 것이다
		 * 현재 method 를 요청한 URL 에 대하여 jsp 을 
		 * 명시적으로 전달한다
		 */
		return "redirect:/books/list";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		/*
		 * return null 형식은
		 * 암시적으로 어떤 jps 파일을 rendering 할 것인지
		 * 알려주는 것이다
		 * 현재 method 요청한 URL 이 명시적으로 명확할 경우
		 * null 을 return 하면 Spring 에서 자체적으로 폼더/파일 형식으로
		 * 구성을 하여준다
		 */
		
		List<BookVO> bookList = bookService.selectAll();
		log.debug(bookList.toString());
		// bookList 에 담긴 데이터를 BOOKS 이름으로 변수에 담아
		// jsp 파일로 보내겠다
		model.addAttribute("BOOKS",bookList);
		model.addAttribute("LAYOUT","BOOK-LIST");
		return "home";
		
	}
	
	/*
	 * RequestMethod 가 없는 Mapping 은
	 * GET 요청이나 POST 요청을 모두 처리하는 method 가 되어버린다
	 * 
	 * method=RequestMethod.GET 로 지정을 하면
	 * a tag link 를 눌렀을때의 요청만 처리하도록 역할을 제한한다.
	 */
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("LAYOUT","BOOK-INPUT");
		return "home";
	}
	
	/*
	 * method=POST 가 부착된 form 으로 감싼 데이터들이 전송되었을때
	 * 요청을 받아 처리할 method
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BookVO bookVO) {
		log.debug("도서정보 : " + bookVO.toString());
		int ret = bookService.insert(bookVO);
		// insert method 를 호출하여 데이터를 저장한 후
		// return 된 결과에 따라 USER 에게 메시지를 보여주고자 할때 
		// 다음과 같은 코드를 사용한다
		
		// if(ret > 0) {
		// 		return "OK";
		// } else {
		// 		return "FAIL";
		// }
		
		// insert 처리를 수행한 후 list 보기 화면으로 전환하라
		return "redirect:/books/list";
		
		/*
		 * Controller method 의 return type 이 String 일때
		 * views/*.jsp 파일을 열어 rendering 을 수행한후 USER 에게 보여라
		 * 이러한 것을 Forwarding 이라고 한다.
		 * 
		 * redirect 로 시작되는 문자열을 만나면
		 * 서버의 다른 URL 로 요청을 전달해 버린다
		 */
	}
	
	@RequestMapping(value="/{isbn}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("isbn") String isbn, Model model ) {
		BookVO bookVO = bookService.findById(isbn);
		model.addAttribute("BOOK", bookVO);

		model.addAttribute("LAYOUT","BOOK-DETAIL");
		return "home";
		
	}
	
	/*
	 * 전달받은 id 값으로 데이터를 Select 하고 model 에 담아서
	 * 입력 form으로 전달한다
	 */
	@RequestMapping(value="/{isbn}/update",method=RequestMethod.GET)
	public String update(@PathVariable("isbn") String isbn, Model model) {
	
		BookVO bookVO = bookService.findById(isbn);
		model.addAttribute("BOOK",bookVO);
		
		model.addAttribute("LAYOUT","BOOK-INPUT");
		return "home";
		
	}
	
	@RequestMapping(value="/{isbn}/update",method=RequestMethod.POST)
	public String update(BookVO bookVO) {
		
		int ret = bookService.update(bookVO);
		
		String retStr = String.format("redirect:/books/%s/detail", bookVO.getIsbn());
		return retStr;
		
	}
	
	
	@RequestMapping(value="/{isbn}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable("isbn") String isbn) {
		
		// 삭제한 데이터개수를 return 한다
		int ret = bookService.delete(isbn);
		return "redirect:/books/list";
	}
	
}
