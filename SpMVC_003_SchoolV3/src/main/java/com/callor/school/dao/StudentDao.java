package com.callor.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.callor.school.dbconfig.DBConnection;
import com.callor.school.dbconfig.DBContract;
import com.callor.school.domain.StudentVO;

/*
 * Dao 클래스
 * Data Access Object
 * DB와 연동하여 SQL을 보내고, 데이터를 수신하는 기능 수행한다
 */
@Component
public class StudentDao {
	
	private final Connection dbConn;
	public StudentDao() {
		dbConn = DBConnection.getDBConnection();
	}
	
	public List<StudentVO> selectAll() {
		
		/*
		 * JDBC 통하여 DBMS 에게 Query 를 보내고
		 * 데이터를 수신하는 객체
		 */
		PreparedStatement pStr = null;
		String sql = DBContract.ST.SELECT;
		
		// sql 문을 전달할 준비
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rSet = pStr.executeQuery();
			
			List<StudentVO> stList = new ArrayList<>();
			
			// 가져올 데이터가 있냐?
			// 있으면 읽어올수 있도록 준비해달라
			while(rSet.next()) {

				StudentVO stVO = new StudentVO();
				stVO.setStNum(rSet.getString(DBContract.ST_COL.ST_NUM));
				stVO.setStName(rSet.getString(DBContract.ST_COL.ST_NAME));
				stVO.setStDept(rSet.getString(DBContract.ST_COL.ST_DEPT));
				stVO.setStAddr(rSet.getString(DBContract.ST_COL.ST_ADDR));
				stVO.setStTel(rSet.getString(DBContract.ST_COL.ST_TEL));
				stVO.setIntGrade(rSet.getInt(DBContract.ST_COL.ST_GRADE));
				stList.add(stVO);
			}
			rSet.close();
			pStr.close();
			return stList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	} // end selectAll
	
	public StudentVO findByNum(String stNum) {
		
		PreparedStatement pStr = null;
		String sql = DBContract.ST.SELECT;
		sql += " WHERE st_num = ? ";
		
		try {
			
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, stNum);
			
			ResultSet rSet = pStr.executeQuery();
			rSet.next();
			StudentVO stVO = new StudentVO();
			stVO.setStNum(rSet.getString(DBContract.ST_COL.ST_NUM));
			stVO.setStName(rSet.getString(DBContract.ST_COL.ST_NAME));
			stVO.setStDept(rSet.getString(DBContract.ST_COL.ST_DEPT));
			stVO.setStAddr(rSet.getString(DBContract.ST_COL.ST_ADDR));
			stVO.setStTel(rSet.getString(DBContract.ST_COL.ST_TEL));
			stVO.setIntGrade(rSet.getInt(DBContract.ST_COL.ST_GRADE));
			
			rSet.close();
			pStr.close();
			return stVO;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
