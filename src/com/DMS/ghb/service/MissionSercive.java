package com.DMS.ghb.service;

import java.util.List;

import com.DMS.ghb.entity.Mission;
import com.DMS.ghb.entity.Teachers;

public interface MissionSercive {
	public boolean saveMission(Mission mission);
	public boolean upMission(Mission mission);
	public boolean deleteMission(Mission mission);
	public Mission getMissionById(String id);
	/**
	 * 参数无意义
	 * @param users
	 * @return
	 */
	public List<Mission> getMIssionByUser(Teachers users);
}
