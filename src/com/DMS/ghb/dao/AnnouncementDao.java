package com.DMS.ghb.dao;

import java.util.List;

import com.DMS.ghb.entity.Announcement;

public interface AnnouncementDao {
	public boolean saveAnn(Announcement announcement);
	public boolean deleteAnn(Announcement announcement);
	public List<Announcement> getAnnAll();
	public Announcement getAnnById(String string);
	public List<Announcement> getAnnByUser(String teaId);
}
