package com.callor.school.exec;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CryptEx2 {
	
	public static void main(String[] args) {
		
		// PasswordEncoder 인터페이스를 사용하기
		PasswordEncoder pass = new BCryptPasswordEncoder();
		String planText = "Korea";
		String encText = pass.encode(planText);
		
		System.out.println("암호화된 문자열 : " + encText);
		System.out.println("암호문 길이 : " + encText.length());
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("비번입력 >> ");
			String input = scan.nextLine();
			
			// 암호화된 문자열과 원본문자열을
			// 매개변수로 전달받아 일치하는지 비교하는 method
			// matches(평문, 암호문)
			boolean bYes = pass.matches(input, encText);
			if( !bYes ) {
				System.out.println("비번이 틀렸습니다");
			} else {
				System.out.println("참 잘했어요~~");
				break;
			}
		}
	}

}
