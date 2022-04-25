package com.callor.school.domain;

/*
 * spring project 에서 VO(DTO) 클래스를 선언할때는
 * 필드 변수를 private 으로 선언하고
 * getter() & setter() 메서드를 선언하고
 * toString() 메서드를 재 정의하고
 * 기본생성자와 필드생성자를 정의해 둔다
 */
public class StudentVO {
	
	private String stNum; // 학번
	private String stName; // 이름
	private int intGrade; // 학년
	private String stTel; // 전화번호
	private String stAddr; // 주소
	private String stDept; // 학과
	
	public StudentVO() {
		
	}
	
	public StudentVO(String stNum, String stName, int intGrade, String stTel, String stAddr, String stDept) {
		this.stNum = stNum;
		this.stName = stName;
		this.intGrade = intGrade;
		this.stTel = stTel;
		this.stAddr = stAddr;
		this.stDept = stDept;
	}

	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public int getIntGrade() {
		return intGrade;
	}
	public void setIntGrade(int intGrade) {
		this.intGrade = intGrade;
	}
	public String getStTel() {
		return stTel;
	}
	public void setStTel(String stTel) {
		this.stTel = stTel;
	}
	public String getStAddr() {
		return stAddr;
	}
	public void setStAddr(String stAddr) {
		this.stAddr = stAddr;
	}
	public String getStDept() {
		return stDept;
	}
	public void setStDept(String stDept) {
		this.stDept = stDept;
	}
	@Override
	public String toString() {
		return "StudentVO [stNum=" + stNum + ", stName=" + stName + ", intGrade=" + intGrade + ", stTel=" + stTel
				+ ", stAddr=" + stAddr + ", stDept=" + stDept + "]";
	}

	
	
}
