package com.DMS.ghb.service.impl;

import java.util.List;

import com.DMS.ghb.dao.MissionDao;
import com.DMS.ghb.entity.Mission;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.MissionSercive;

public class MissionServiceImpl implements MissionSercive {
	private MissionDao dao;

	@Override
	public boolean saveMission(Mission mission) {
		return dao.saveMission(mission);
	}

	@Override
	public boolean upMission(Mission mission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMission(Mission mission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Mission getMissionById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mission> getMIssionByUser(Teachers users) {
		return dao.getMIssionByUser(users);
	}

	public MissionDao getDao() {
		return dao;
	}

	public void setDao(MissionDao dao) {
		this.dao = dao;
	}

}
