package com.callor.images.persistance;

import java.util.List;

import com.callor.images.model.StartMenuDTO;
import com.callor.images.model.WorkOutDTO;

public interface SelfitDao {
	
	public List<WorkOutDTO> workOutView(String sl_scid);
	public List<StartMenuDTO> selectStartMenu();
	public List<StartMenuDTO> selectDaySet(String sc_num);

}
