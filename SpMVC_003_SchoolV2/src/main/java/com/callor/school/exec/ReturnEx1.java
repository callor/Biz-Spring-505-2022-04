package com.callor.school.exec;

public class ReturnEx1 {
	
	public static void main(String[] args) {
		Integer result = add("30","40");
		System.out.println(result);
		
		result = add("30 ", "40 ");
		if(result == null) {
			System.out.println("연산이 잘못되었습니다");
		} else {
			System.out.println(result);	
		}
		
		
	}
	
	// 두개의 문자열형 정수를 매개변수로 받아
	// 숫자 연산을 수행한 후 결과를 return
	private static Integer add(String num1, String num2) {
		int intNum1 = 0;
		int intNum2 = 0;
		try {
			intNum1 = Integer.valueOf(num1);
			intNum2 = Integer.valueOf(num2);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		int intSum = intNum1 + intNum2;
		return intSum;
	}

}
