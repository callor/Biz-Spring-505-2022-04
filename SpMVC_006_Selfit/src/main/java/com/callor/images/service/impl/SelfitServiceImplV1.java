package com.callor.images.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.StartMenuDTO;
import com.callor.images.model.WorkOutDTO;
import com.callor.images.persistance.SelfitDao;
import com.callor.images.service.SelfitService;

@Service(QualifierConfig.SERVICE.SELFIT_V1)
public class SelfitServiceImplV1 implements SelfitService{

	protected final SelfitDao selfitDao;
	public SelfitServiceImplV1(SelfitDao selfitDao) {
			this.selfitDao = selfitDao;
	}
	
	@Override
	public void startPage(Model model) {

		List<StartMenuDTO> startMenus = selfitDao.selectStartMenu();
		
		List<StartMenuDTO> beginMenus = new ArrayList<>();
		List<StartMenuDTO> middleMenus = new ArrayList<>();
		List<StartMenuDTO> advMenus = new ArrayList<>();
		
		for(StartMenuDTO dto : startMenus) {
			if(dto.getSc_num().substring(0,2).equals("01")) {
				beginMenus.add(dto);
			} else if(dto.getSc_num().substring(0,2).equals("02")) {
				middleMenus.add(dto);
			} else if(dto.getSc_num().substring(0,2).equals("03")) {
				advMenus.add(dto);
			}
		}

		// 각각  메뉴를 Map 형태의 데이터로 묶어서
		// 한번에 model 담기
		Map<String, List<StartMenuDTO>> menuMaps = new HashMap<>();
		menuMaps.put("BEGIN",beginMenus);
		menuMaps.put("MIDDLE", middleMenus);
		menuMaps.put("ADV", advMenus);
		model.addAttribute("MENUMAPS", menuMaps);

		
		// 각각 메뉴를 개별적으로 model 에 담기
		model.addAttribute("BEGIN_MENU",beginMenus);
		model.addAttribute("MIDDLE_MENU",middleMenus);
		model.addAttribute("ADV_MENU",advMenus);
		
	}

	@Override
	public void getDaySetList(Model model, String sc_num) {
		List<StartMenuDTO> daySetList = selfitDao.selectDaySet(sc_num);
		model.addAttribute("DAYS",daySetList);
	}

	@Override
	public void getDaySetList(Model model, String sc_num, String sc_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WorkOutDTO getDayHealth(String sc_id, String listid) {
		// TODO Auto-generated method stub
		return null;
	}

}
