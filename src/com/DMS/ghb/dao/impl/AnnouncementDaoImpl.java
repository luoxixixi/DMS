package com.DMS.ghb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.DMS.ghb.dao.AnnouncementDao;
import com.DMS.ghb.entity.Announcement;

public class AnnouncementDaoImpl extends HibernateDaoSupport implements
		AnnouncementDao {

	@Override
	public boolean saveAnn(Announcement announcement) {
		try {
			getHibernateTemplate().save(announcement);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAnn(Announcement announcement) {
		try {
			getHibernateTemplate().delete(announcement);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Announcement> getAnnAll() {
		try {
			String hql = "from Announcement";
			List<Announcement> announcements = (List<Announcement>) getHibernateTemplate()
					.find(hql);
			if (announcements != null && announcements.size() > 0) {
				return announcements;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Announcement getAnnById(String id) {
		try {
			Announcement announcement = getHibernateTemplate().get(
					Announcement.class, id);
			return announcement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Announcement> getAnnByUser(String teaId) {
		try {
			String hql = "from Announcement where leavel='2'";
			@SuppressWarnings("unchecked")
			List<Announcement> announcements = (List<Announcement>) getHibernateTemplate()
					.find(hql);
			if (announcements != null && announcements.size() > 0) {
				return announcements;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
