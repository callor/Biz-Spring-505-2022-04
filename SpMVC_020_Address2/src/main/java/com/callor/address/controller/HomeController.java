package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.model.AddressVO;
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
	public String home(Model model) {
		List<AddressVO> addrList = addrService.selectAll();
		model.addAttribute("ADDRS", addrList);
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO addr) {
		log.debug("받은 데이터 {}", addr.toString());
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
		return "home";
	}


}
