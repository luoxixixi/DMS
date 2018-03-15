package com.DMS.ghb.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.jni.User;

import com.DMS.ghb.entity.Announcement;
import com.DMS.ghb.entity.Mission;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.AnnouncementService;
import com.DMS.ghb.service.MissionSercive;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.service.TeacherService;
import com.DMS.ghb.service.UserService;
import com.DMS.ghb.util.HttpUtil;
import com.DMS.ghb.util.OtherUtils;
import com.DMS.ghb.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService service;
	private StudentService studentService;
	private TeacherService teacherService;
	private MissionSercive missionSercive;
	private AnnouncementService announcementService;

	/**
	 * ��¼
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		String name = ServletActionContext.getRequest().getParameter("name");
		String psw = ServletActionContext.getRequest().getParameter("psw");
		HttpSession session = ServletActionContext.getRequest().getSession();
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		Users user = service.getUserByName(name, psw);
		if (user != null) {
			session.setAttribute("suser", user);
			String userType = user.getType();
			if (userType.equals("1")) {// ѧ��
				Students student = studentService.getStudentByNum(Long
						.parseLong(user.getUserName()));
				session.setAttribute("user", student);
				return "STUDENT";
			} else if (userType.equals("2")) {// ��ʦ
				Teachers teachers = teacherService.getTeacherByPhone(user
						.getUserName());
				session.setAttribute("user", teachers);
				return "TEACHER";
			} else if (userType.equals("3")) {// ����
				Teachers teacher = teacherService.getTeacherByPhone("@zhuren");
				session.setAttribute("user", teacher);
				return "DIRECTOR";
			} else if (userType.equals("4")) {// ��zho ��
				session.setAttribute("user", "����Ա");
				return "MANAGE";
			} else {
				addActionMessage("�����û����������Ƿ���ȷ��");
				return NONE;
			}
		} else {
			this.clearErrorsAndMessages();
			addActionMessage("�����û����������Ƿ���ȷ��");
			return NONE;
		}
	}

	/**
	 * ��ҳ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getIndexData() throws Exception {
		getMissionByUser();
		showAnnByUser();
		return SUCCESS;
	}

	/**
	 * ��ѯ����ѧ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAllstudent() throws Exception {
		List<Students> allStu = studentService.getAllStu();
		if (allStu != null && allStu.size() > 0) {
			HttpUtil.getRequset().setAttribute("allstudent", allStu);
		} else {
			allStu = new ArrayList<Students>();
			HttpUtil.getRequset().setAttribute("allstudent", allStu);
		}
		return SUCCESS;
	}

	/**
	 * ��ѯ���н�ʦ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAllTeacher() throws Exception {
		String isStu = HttpUtil.getRequset().getParameter("isStu");
		if (isStu != null) {
			Students students = (Students) HttpUtil.getSession().getAttribute(
					"user");
			Teachers teacher = studentService.getStuById(students.getStuId())
					.getTeachers();
			if (teacher != null) {
				List<Teachers> teachers = new ArrayList<Teachers>();
				teachers.add(teacher);
				HttpUtil.getRequset().setAttribute("allteacher", teachers);
				return SUCCESS;
			}
		}
		List<Teachers> teachers = teacherService.getTeachers();
		if (teachers != null && teachers.size() > 0) {
			HttpUtil.getRequset().setAttribute("allteacher", teachers);
		} else {
			teachers = new ArrayList<Teachers>();
			HttpUtil.getRequset().setAttribute("allteacher", teachers);
		}
		return SUCCESS;
	}

	/**
	 * �޸�����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changePassword() throws Exception {
		String psw = HttpUtil.getRequset().getParameter("psw");
		Users user = (Users) HttpUtil.getSession().getAttribute("suser");
		user.setUserPsw(psw);
		boolean updataUsers = service.updataUsers(user);
		if (updataUsers) {
			HttpUtil.getSession().setAttribute("suser", null);
			HttpUtil.getSession().setAttribute("user", null);
			HttpUtil.getResponse().getWriter().print(SUCCESS);
			return null;
		} else {
			HttpUtil.getResponse().getWriter().print(ERROR);
			return null;
		}
	}

	/**
	 * �޸�ѧ����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changeStuInfo() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String stuid = requset.getParameter("stuId");
		String stuname = requset.getParameter("stuname");
		String stunum = requset.getParameter("stunum");
		String studept = requset.getParameter("studept");
		String stumajor = requset.getParameter("stumajor");
		String stucls = requset.getParameter("stucls");

		Students students = studentService.getStuById(stuid);
		Users user = service.getUserByName(students.getStuNum() + "");
		students.setName(stuname);
		students.setStuNum(OtherUtils.getLong(stunum));
		students.setDepartments(studept);
		students.setMajor(stumajor);
		students.setClasses(stucls);
		user.setUserName(stunum);
		boolean updataStudents = studentService.updataStudents(students);
		boolean updataUsers = service.updataUsers(user);
		if (updataStudents && updataUsers) {
			HttpUtil.getSession().setAttribute("user", students);
			HttpUtil.getResponse().getWriter().print("success");
			return null;
		}
		return null;
	}

	/**
	 * �޸Ľ�ʦ��Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changeTeaInfo() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String id = requset.getParameter("teacherId");
		String name = requset.getParameter("teacherName");
		String phone = requset.getParameter("teacherPhone");
		String major = requset.getParameter("tMajor");
		String info = requset.getParameter("tInfo");
		Teachers teacherByPhone = teacherService.getTeacherByPhone(phone);
		Teachers teacerById = teacherService.getTeacerById(id);
		HttpServletResponse response = ServletActionContext.getResponse();
		if (teacherByPhone != null) {
			if (!(teacherByPhone.getPhone().equals(teacerById.getPhone()))) {
				response.getWriter().print("1");
				return null;
			}
		}
		Users userByName = service.getUserByName(teacerById.getPhone());
		teacerById.setName(name);
		teacerById.setPhone(phone);
		teacerById.setMajor(major);
		teacerById.setTeaInfo(info);
		userByName.setUserName(phone);
		boolean updataUsers = service.updataUsers(userByName);
		boolean updataTeachers = teacherService.updataTeachers(teacerById);
		if (updataTeachers && updataUsers) {
			HttpUtil.getSession().setAttribute("user", teacerById);
			response.getWriter().print("success");
			return null;
		}
		return null;
	}

	/**
	 * ��ӽ�ʦ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveTeacher() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String name = requset.getParameter("teacherName");
		String phone = requset.getParameter("teacherPhone");
		String psw = requset.getParameter("psw2");

		Teachers teachers = new Teachers();
		teachers.setName(name);
		teachers.setPhone(phone);

		if (psw == null || psw.equals("")) {
			psw = "111";
		}
		Users users = new Users();
		users.setUserName(phone);
		users.setUserPsw(psw);
		users.setType("2");
		HttpServletResponse response = ServletActionContext.getResponse();
		Teachers teacherByPhone = teacherService.getTeacherByPhone(phone);
		if (teacherByPhone != null) {
			response.getWriter().print("1");
			return null;
		}

		boolean saveUser = service.saveUser(users);
		boolean saveTeachers = teacherService.saveTeachers(teachers);
		if (saveTeachers && saveUser) {
			response.getWriter().print("success");
			return null;
		}
		return null;
	}

	/**
	 * ���ѧ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveStu() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String stuname = requset.getParameter("stuname");
		String stunum = requset.getParameter("stunum");
		String studept = requset.getParameter("studept");
		String stumajor = requset.getParameter("stumajor");
		String stucls = requset.getParameter("stucls");
		Students students = new Students();
		students.setName(stuname);
		students.setStuNum(OtherUtils.getLong(stunum));
		students.setDepartments(studept);
		students.setMajor(stumajor);
		students.setClasses(stucls);
		Users users = new Users();
		users.setUserName(stunum);
		users.setUserPsw(stunum);
		users.setType("1");
		boolean saveStudent = studentService.saveStudent(students);
		boolean saveUser = service.saveUser(users);
		if (saveStudent && saveUser) {

			HttpServletResponse response = ServletActionContext.getResponse();
			response.getWriter().print("success");
			return null;
		}
		return null;
	}

	/**
	 * ɾ����ʦ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteTea() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String teaId = requset.getParameter("teaId");
		Teachers teacerById = teacherService.getTeacerById(teaId);
		Users userByName = service.getUserByName(teacerById.getPhone());
		System.out.println(userByName.getUserId());
		boolean deleteTeachers = teacherService.deleteTeachers(teacerById);
		boolean deleteUsers = service.deleteUsers(userByName);
		if (deleteTeachers && deleteUsers) {
			HttpUtil.getResponse().getWriter().print("success");
		}
		return null;
	}

	/**
	 * ɾ��ѧ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteStu() throws Exception {
		String stuId = HttpUtil.getRequset().getParameter("stuId");
		Students students = studentService.getStuById(stuId);
		boolean deleteStudents = studentService.deleteStudents(students);
		Users userByName = service.getUserByName(students.getStuNum() + "");
		boolean deleteUsers = service.deleteUsers(userByName);
		if (deleteStudents && deleteUsers) {
			HttpUtil.getResponse().getWriter().print("success");
		}
		return null;
	}

	/**
	 * ѧ��ѡ���ʦ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String choiceTeacher() throws Exception {
		String teaId = HttpUtil.getRequset().getParameter("teaId");
		Students student = (Students) HttpUtil.getSession()
				.getAttribute("user");
		Teachers teacerById = teacherService.getTeacerById(teaId);
		student.setTeachers(teacerById);
		boolean updataStudents = studentService.updataStudents(student);
		if (updataStudents) {
			HttpUtil.getResponse().getWriter().print("success");
			return null;
		}
		HttpUtil.getResponse().getWriter().print("error");
		return null;
	}

	/**
	 * ��ȡ��ʦ�µ�ѧ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getStu() throws Exception {
		Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
				"user");
		Set<Students> students = teacherService.getTeacerById(
				teachers.getTeaId()).getStudents();
		List<Students> student = null;
		if (students == null) {
			student = new ArrayList<Students>();
		} else {
			student = new ArrayList<Students>();
			System.out.println(students.size());
			student.addAll(students);
		}
		HttpUtil.getRequset().setAttribute("students", student);
		return SUCCESS;
	}

	/**
	 * ��ʦѡ��ѧ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String choiceStu() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String stuId = requset.getParameter("stuId");
		Students stuById = studentService.getStuById(stuId);
		stuById.setTeachers(null);
		boolean updataStudents = studentService.updataStudents(stuById);
		if (updataStudents) {
			HttpUtil.getResponse().getWriter().print("success");
			return null;
		}
		HttpUtil.getResponse().getWriter().print("error");
		return null;
	}

	/**
	 * �˳�ϵͳ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exitSystem() throws Exception {
		HttpUtil.getSession().setAttribute("suser", null);
		HttpUtil.getSession().setAttribute("user", null);
		return SUCCESS;
	}

	/**
	 * ��ѯ�����б�
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean getMissionByUser() throws Exception {
		Users user = (Users) HttpUtil.getSession().getAttribute("suser");
		List<Mission> missions = new ArrayList<Mission>();
		if (user.getType().equals("1")) {
			Students student = (Students) HttpUtil.getSession().getAttribute(
					"user");
			Set<Mission> mission = teacherService.getTeacerById(
					student.getTeachers().getTeaId()).getMissions();
			missions = missionSercive.getMIssionByUser(student.getTeachers());
			if (missions == null) {
				missions = new ArrayList<Mission>();
			}
			missions.addAll(mission);
		} else {
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
					"user");
			missions = missionSercive.getMIssionByUser(null);
			if (missions == null) {
				missions = new ArrayList<Mission>();
			}
		}
		Collections.sort(missions, new Comparator<Mission>() {
			@Override
			public int compare(Mission o1, Mission o2) {
				long l = TimeUtil.getLongTime(o1.getMissionTime())
						- TimeUtil.getLongTime(o2.getMissionTime());
				int j = 0;
				if (l > 0) {
					j = 1;
				} else if (l < 0) {
					j = -1;
				}
				return 1;
			}
		});
		if (missions.size() > 10) {
			missions.subList(0, 9);
		}
		HttpUtil.getRequset().setAttribute("missions", missions);
		return true;
	}

	/**
	 * �����û��鿴����
	 * 
	 * @return
	 * @throws Exception
	 */

	private boolean showAnnByUser() throws Exception {
		Users user = (Users) HttpUtil.getSession().getAttribute("suser");
		List<Announcement> announcementByUser = new ArrayList<Announcement>();
		if (user.getType().equals("3")) {
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
					"user");
			Set<Announcement> announcements = teacherService.getTeacerById(
					teachers.getTeaId()).getAnnouncements();
			announcementByUser.addAll(announcements);
		} else if (user.getType().equals("2")) {
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
					"user");
			announcementByUser = announcementService
					.getAnnouncementByUser(teachers.getTeaId());
			Set<Announcement> announcements = teacherService.getTeacerById(
					teachers.getTeaId()).getAnnouncements();
			announcementByUser.addAll(announcements);
		} else if (user.getType().equals("1")) {
			Students student = (Students) HttpUtil.getSession().getAttribute(
					"user");
			announcementByUser = announcementService
					.getAnnouncementByUser(null);
			Teachers teachers = studentService.getStuById(student.getStuId())
					.getTeachers();
			Set<Announcement> announcements = new HashSet<Announcement>();
			if (teachers != null) {
				announcements = teachers.getAnnouncements();
				if (announcements == null) {
					announcements = new HashSet<Announcement>();
				}
			}
			announcementByUser.addAll(announcements);
		}
		Collections.sort(announcementByUser, new Comparator<Announcement>() {
			@Override
			public int compare(Announcement o1, Announcement o2) {
				return o2.getTime().compareTo(o1.getTime());
			}
		});
		if (announcementByUser.size() > 10) {
			announcementByUser.subList(0, 9);
		}
		HttpUtil.getRequset().setAttribute("annList", announcementByUser);
		return true;
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

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public MissionSercive getMissionSercive() {
		return missionSercive;
	}

	public void setMissionSercive(MissionSercive missionSercive) {
		this.missionSercive = missionSercive;
	}

	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}

	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

}
