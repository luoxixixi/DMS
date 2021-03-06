package com.DMS.ghb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.DMS.ghb.dao.MissionDao;
import com.DMS.ghb.entity.Announcement;
import com.DMS.ghb.entity.Mission;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;

public class MissionDaoImpl extends HibernateDaoSupport implements MissionDao {

	@Override
	public boolean saveMission(Mission mission) {
		try {
			getHibernateTemplate().save(mission);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean upMission(Mission mission) {
		try {
			getHibernateTemplate().update(mission);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteMission(Mission mission) {
		try {
			getHibernateTemplate().delete(mission);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Mission getMissionById(String id) {
		try {
			Mission mission = getHibernateTemplate().get(Mission.class, id);
			return mission;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Mission();
	}

	@Override
	public List<Mission> getMIssionByUser(Teachers users) {
		try {
			String hql = "from Mission where leavel='2'";
			@SuppressWarnings("unchecked")
			List<Mission> missions = (List<Mission>) getHibernateTemplate()
					.find(hql);
			if (missions != null && missions.size() > 0) {
				return missions;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
