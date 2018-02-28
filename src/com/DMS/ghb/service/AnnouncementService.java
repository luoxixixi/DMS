package com.DMS.ghb.service;

import java.util.List;

import com.DMS.ghb.entity.Announcement;

public interface AnnouncementService {
	public boolean saveAnnouncement(Announcement announcement);
	public List<Announcement> getAnnouncementByUser(String Userid);
	public Announcement getAnnouncementById(String id);
	public List<Announcement> getAnnouncement();
	public boolean deleteAnnouncement(String id);
}
