package com.DMS.ghb.service.impl;

import java.util.List;

import com.DMS.ghb.dao.AnnouncementDao;
import com.DMS.ghb.entity.Announcement;
import com.DMS.ghb.service.AnnouncementService;

public class AnnouncementServiceImpl implements AnnouncementService {
	private AnnouncementDao dao;

	public AnnouncementDao getDao() {
		return dao;
	}

	public void setDao(AnnouncementDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean saveAnnouncement(Announcement announcement) {
		boolean b = dao.saveAnn(announcement);
		return b;
	}

	@Override
	public List<Announcement> getAnnouncementByUser(String Userid) {
		long id = Long.parseLong(Userid);
		List<Announcement> annByUser = dao.getAnnByUser(id);
		if (annByUser != null) {
			return annByUser;
		}
		return null;
	}

	@Override
	public Announcement getAnnouncementById(Announcement id) {
		Announcement annById = dao.getAnnById(id.getAnnId());
		return annById;
	}

	@Override
	public List<Announcement> getAnnouncement() {
		List<Announcement> annAll = dao.getAnnAll();
		if (annAll != null) {
			return annAll;
		}
		return null;
	}

	@Override
	public boolean deleteAnnouncement(Announcement announcement) {
		boolean deleteAnn = dao.deleteAnn(announcement);
		return deleteAnn;
	}

}
