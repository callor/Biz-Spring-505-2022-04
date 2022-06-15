package com.callor.images.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.images.model.StartMenuDTO;
import com.callor.images.model.WorkOutDTO;

public interface SelfitDao {
	
	public List<WorkOutDTO> workOutView();
	public List<StartMenuDTO> selectStartMenu();
	public List<StartMenuDTO> selectDaySet(String sc_num);
	
	public List<StartMenuDTO> selectByScNum(String sc_num);
	public List<WorkOutDTO> selectWorkOut(String sc_id);
	public WorkOutDTO selectDayHealth(
			@Param("sc_id") String sc_id, 
			@Param("sc_listid") String listid);

}
