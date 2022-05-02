package com.callor.school.exec;

public class ExecV1 {
	
	public static void main(String[] args) {
		
		int[] nums = new int[100];
		for(int i = 0 ; i < nums.length ; i++) {
			nums[i] = (int)(Math.random() * 100) + 1;
		}
		
		for(int num : nums) {
			System.out.printf("%d\t",num);	
		}
		System.out.println();
		
		for(int i = 0 ; i < nums.length ;i++) {
			for(int j = i +1; j < nums.length ; j++) {
				if(nums[i] > nums[j]) {
					// nums[i] 값과 num[j] 값을 서로 교환
					int _t = nums[i];
					nums[i] = nums[j];
					nums[j] = _t;
				}
			}
		}
		for(int num : nums) {
			System.out.printf("%d\t",num);	
		}
		System.out.println();

		
		
		
	}
	

}
