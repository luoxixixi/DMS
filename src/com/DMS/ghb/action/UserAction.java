package com.DMS.ghb.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.service.TeacherService;
import com.DMS.ghb.service.UserService;
import com.DMS.ghb.util.HttpUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService service;
	private StudentService studentService;
	private TeacherService teacherService;

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
				Teachers teacher = teacherService.getTeacherByPhone(user
						.getUserName());
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
			System.out.println("2");
			addActionMessage("�����û����������Ƿ���ȷ��");
			return NONE;
		}
	}

	

	/**
	 * �޸�����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changePassword() throws Exception {
		System.out.println("���뷽��");
		Teachers teachers =teacherService.getTeacherByPhone("13888888888");
	 Set<Students> students = teachers.getStudents();
		for (Students students2 : students) {
			System.out.println(students2.getName());
		}
		return SUCCESS;
	}

	/**
	 * �޸�ѧ����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changeStuInfo() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * �޸Ľ�ʦ��Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changeTeaInfo() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * ��ӽ�ʦ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveTeacher() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * ���ѧ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveStu() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * ɾ����ʦ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteTea() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * ɾ��ѧ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteStu() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * ѧ��ѡ���ʦ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String choiceTeacher() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		Students student = (Students) HttpUtil.getSession().getAttribute("user");
		Teachers teachers =teacherService.getTeacherByPhone("13888888888");
		student.setTeachers(teachers);
		studentService.updataStudents(student);
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
		requset.getParameter("");
		return SUCCESS;
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

}
