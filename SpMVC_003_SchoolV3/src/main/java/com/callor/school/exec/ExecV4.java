package com.callor.school.exec;

import java.util.ArrayList;
import java.util.List;

public class ExecV4 {

	public static void main(String[] args) {
		List<ScoreVO> scList = new ArrayList<>();
		for(int i = 0 ; i < 10 ; i++) {
			int iKor = (int)(Math.random() * 50) + 51;
			int iEng = (int)(Math.random() * 50) + 51;
			int iMath = (int)(Math.random() * 50) + 51;
			ScoreVO scVO = new ScoreVO();
			scVO.intKor = iKor;
			scVO.intEng = iEng;
			scVO.intMath = iMath;
			scVO.intSum = iKor + iEng + iMath;
			scList.add(scVO);
		}
		int size = scList.size();
		for(int i = 0 ; i < size ; i++ ) {
			for(int j = i + 1; j < size ; i++) {
				if(scList.get(i).intSum > scList.get(j).intSum) {
					ScoreVO sVO = scList.get(i);
					scList.set(i, scList.get(j));
					scList.set(j, sVO);
				}
			}
		}
	}
	
}

