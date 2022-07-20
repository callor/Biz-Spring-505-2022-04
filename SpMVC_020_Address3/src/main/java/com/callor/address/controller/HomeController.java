package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	// Controller 와 Service 연결하기
	private final AddressService addrService;

	public HomeController(AddressService addrService) {
		this.addrService = addrService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model , 
			@RequestParam(name = "pageno",
				required = false, 
				defaultValue = "1") int pageno,
				SearchPage searchPage
			) {

		
		// List<AddressVO> addrList = addrService.selectAll();
		
		searchPage.setCurrentPageNo(pageno);
		// 페이지 계산
		addrService.searchAndPage(model,searchPage);
		log.debug("페이지 계산 {}",searchPage.toString());
		
		// 데이터 가져오기
		List<AddressVO> addrList = addrService.searchAndPage(searchPage);
		
		model.addAttribute("ADDRS", addrList);
		return "home";
	
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO addr) {
		log.debug("받은 데이터 {}", addr.toString());
		addrService.insert(addr);
		return "redirect:/";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "write";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(AddressVO addr) {
		addrService.insert(addr);
		return "redirect:/";
	}
	

	// 요청 http://localhost:8080/address/detail?seq=3
	public String detail(@RequestParam("seq") String strSeq) {

		log.debug("SEQ {}", strSeq);
		long a_seq = Long.valueOf(strSeq);
		log.debug("SEQ {}", a_seq);

		return "detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(
			// 숫자형 매개변수를 사용하면서 400 오류를 방지하는 코드
			@RequestParam(name = "seq", required = false, defaultValue = "0") long a_seq, Model model) {
		log.debug("SEQ {}", a_seq);

		AddressVO addr = addrService.findById(a_seq);
		log.debug("find {}", addr.toString());
		model.addAttribute("ADDR", addr);
		return "detail";

	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(
			@RequestParam(name="seq", required= false, defaultValue="0") long a_seq,
			Model model) {
		
		AddressVO addr = addrService.findById(a_seq);
		model.addAttribute("ADDR", addr);
		return "write";
	}
	
	// localhost:8080/address/update?seq=3
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestParam("seq") long seq, AddressVO address) {
		address.setA_seq(seq);
		addrService.update(address);
		return "redirect:/detail?seq=" + seq;
	}
	
	/*
	 * Controller의 method 에서 문자열을 return 하면
	 * tiles/layout.xml 파일에서 해당하는 문자열로 선언된 definition 을 찾는다
	 * 해당하는 문자열로 선언된 definition 있으면 layout.xml 설정된 대로
	 * tiles 가 작동되어 layout 만들고 rendering 하여 응답을 한다
	 * 
	 * 만약 layout.xml 에 해당하는 definition 이 없으면
	 * InternalResourceViewResolver 가 작동되어 /views/문자열.jsp 파일을 찾아서
	 * rendering 하여 응답한다.
	 */
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String about() {
		return "about";
	}


}
