package com.callor.ems.service;

import com.callor.ems.model.EmsVO;
import com.callor.ems.model.UserVO;

public interface SendMailService {
	public void sendMail(EmsVO emsVO);
	public void sendMail(EmsVO emsVO, UserVO userVO);
}
