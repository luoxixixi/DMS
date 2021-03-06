package com.DMS.ghb.dao;

import java.util.List;

import com.DMS.ghb.entity.Mission;
import com.DMS.ghb.entity.Teachers;

public interface MissionDao {
	public boolean saveMission(Mission mission);
	public boolean upMission(Mission mission);
	public boolean deleteMission(Mission mission);
	public Mission getMissionById(String id);
	public List<Mission> getMIssionByUser(Teachers users);

}
