package com.DMS.ghb.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.DMS.ghb.entity.Announcement;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.AnnouncementService;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.service.TeacherService;
import com.DMS.ghb.util.HttpUtil;
import com.DMS.ghb.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AnnouncementAction extends ActionSupport {
	private AnnouncementService service;
	private StudentService studentService;
	private TeacherService teacherService;

	
	/**
	 * 所有公告
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
	 * 查看公告
	 * 
	 * @return
	 */
	public String showAnn() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String id = requset.getParameter("annId");
		Announcement announcementById = service.getAnnouncementById(id);
		if (announcementById != null) {
			requset.setAttribute("announcementById", announcementById);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 发布公告
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveAnn() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String head = requset.getParameter("title");
		String body = requset.getParameter("body");
		Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
				"user");

		Announcement announcement = new Announcement();
		announcement.setHead(head);
		announcement.setBody(body);
		announcement.setTeaId(teachers);
		announcement.setTime(TimeUtil.timeNow());
		if (teachers.getPhone().equals("@zhuren")) {
			announcement.setLeavel("2");
		} else {
			announcement.setLeavel("1");
		}
		boolean saveAnnouncement = service.saveAnnouncement(announcement);
		if (saveAnnouncement) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 删除公告
	 * 
	 * @return
	 */
	public String deleteAnn() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String id = requset.getParameter("annId");
		
		boolean deleteAnnouncement = service.deleteAnnouncement(id);
		if (deleteAnnouncement) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 根据用户查看公告
	 * 
	 * @return
	 * @throws Exception
	 */

	public String showAnnByUser() throws Exception {
		Users user = (Users) HttpUtil.getSession().getAttribute("suser");
		List<Announcement> announcementByUser = new ArrayList<Announcement>();
		if(user.getType().equals("3")){
			Teachers teachers =(Teachers) HttpUtil.getSession().getAttribute("user");
			Set<Announcement> announcements =teacherService.getTeacerById(teachers.getTeaId()).getAnnouncements();
			announcementByUser.addAll(announcements);
		}else if (user.getType().equals("2")) {
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute("user");
			announcementByUser = service.getAnnouncementByUser(teachers.getTeaId());
			Set<Announcement> announcements =teacherService.getTeacerById(teachers.getTeaId()).getAnnouncements();
			announcementByUser.addAll(announcements);
		}else if (user.getType().equals("1")) {
			Students student = (Students) HttpUtil.getSession().getAttribute("user");
			announcementByUser = service.getAnnouncementByUser(student.getTeachers().getTeaId());
			Set<Announcement> announcements =studentService.getStuById(student.getStuId()).getTeachers().getAnnouncements();
			announcementByUser.addAll(announcements);
		}
		Collections.sort(announcementByUser, new Comparator<Announcement>() {
			@Override
			public int compare(Announcement o1, Announcement o2) {
				return o2.getTime().compareTo(o1.getTime());
			}
		});
		HttpUtil.getRequset().setAttribute("annList", announcementByUser);
		return SUCCESS;
	}

	public AnnouncementService getService() {
		return service;
	}

	public void setService(AnnouncementService service) {
		this.service = service;
	}
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

}
