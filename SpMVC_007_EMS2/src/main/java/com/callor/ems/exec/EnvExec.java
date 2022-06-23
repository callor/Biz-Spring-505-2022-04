package com.callor.ems.exec;

import java.util.Map;

public class EnvExec {
	
	public static void main(String[] args) {
		
		Map<String, String> envList = System.getenv();
		String naverPass = envList.get("NAVER");
		System.out.println(naverPass);
		
	}

}
