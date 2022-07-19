package com.callor.address.service;

import org.springframework.ui.Model;

import com.callor.address.model.SearchPage;
import com.callor.address.persistance.AddressDao;

public interface AddressService extends AddressDao {
	
	public void searchAndPage(Model model,SearchPage searchPage);

}
