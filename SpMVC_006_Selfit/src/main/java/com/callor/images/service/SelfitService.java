package com.callor.images.service;

import org.springframework.ui.Model;

import com.callor.images.model.WorkOutDTO;

public interface SelfitService {
	public void startPage(Model model) ;
	public void getDaySetList(Model model, String sc_num);
	public void getDaySetList(Model model, String sc_num, String sc_id);
	public WorkOutDTO getDayHealth(String sc_id, String listid);
}
