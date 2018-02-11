package com.DMS.ghb.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.DMS.ghb.entity.Announcement;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.AnnouncementService;
import com.DMS.ghb.util.HttpUtil;
import com.DMS.ghb.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AnnouncementAction extends ActionSupport {
	private AnnouncementService service;

	/**
	 * ���й���
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showAllAnn() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		List<Announcement> announcement = service.getAnnouncement();
		if (announcement != null) {
			requset.setAttribute("announcement", announcement);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * �鿴����
	 * 
	 * @return
	 */
	public String showAnn() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String id = HttpUtil.transForUTF(requset.getParameter("annId"));
		Announcement announcement = new Announcement();
		announcement.setAnnId(id);
		Announcement announcementById = service
				.getAnnouncementById(announcement);
		if (announcementById != null) {
			requset.setAttribute("announcementById", announcementById);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * ��������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveAnn() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String head = HttpUtil.transForUTF(requset.getParameter("title"));
		String body = HttpUtil.transForUTF(requset.getParameter("body"));
		Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
				"user");
		Announcement announcement = new Announcement();
		announcement.setHead(head);
		announcement.setBody(body);
		announcement.setTeaId(teachers);
		announcement.setTime(TimeUtil.timeNow());
		boolean saveAnnouncement = service.saveAnnouncement(announcement);
		if (saveAnnouncement) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * ɾ������
	 * 
	 * @return
	 */
	public String deleteAnn() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String id = HttpUtil.transForUTF(requset.getParameter("annId"));
		Announcement announcement = new Announcement();
		announcement.setAnnId(id);
		boolean deleteAnnouncement = service.deleteAnnouncement(announcement);
		if (deleteAnnouncement) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * �����û��鿴����
	 * 
	 * @return
	 * @throws Exception
	 */

	public String showAnnByUser() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	public AnnouncementService getService() {
		return service;
	}

	public void setService(AnnouncementService service) {
		this.service = service;
	}

}
