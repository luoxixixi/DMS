package com.DMS.ghb.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.jni.User;

import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.service.TeacherService;
import com.DMS.ghb.service.UserService;
import com.DMS.ghb.util.HttpUtil;
import com.DMS.ghb.util.OtherUtils;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService service;
	private StudentService studentService;
	private TeacherService teacherService;

	/**
	 * 登录
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
			if (userType.equals("1")) {// 学生
				Students student = studentService.getStudentByNum(Long
						.parseLong(user.getUserName()));
				session.setAttribute("user", student);
				return "STUDENT";
			} else if (userType.equals("2")) {// 教师
				Teachers teachers = teacherService.getTeacherByPhone(user
						.getUserName());
				session.setAttribute("user", teachers);
				return "TEACHER";
			} else if (userType.equals("3")) {// 主任
				Teachers teacher = teacherService.getTeacherByPhone(user
						.getUserName());
				session.setAttribute("user", teacher);
				return "DIRECTOR";
			} else if (userType.equals("4")) {// 管zho 理
				session.setAttribute("user", "管理员");
				return "MANAGE";
			} else {
				addActionMessage("请检查用户名或密码是否正确！");
				return NONE;
			}
		} else {
			this.clearErrorsAndMessages();
			addActionMessage("请检查用户名或密码是否正确！");
			return NONE;
		}
	}
	/**
	 * 查询所有学生
	 * @return
	 * @throws Exception
	 */
	public String getAllstudent() throws Exception{
		List<Students> allStu = studentService.getAllStu();
		if(allStu!=null&&allStu.size()>0){
			HttpUtil.getRequset().setAttribute("allstudent", allStu);
		}else {
			allStu = new ArrayList<Students>();
			HttpUtil.getRequset().setAttribute("allstudent", allStu);
		}
		return SUCCESS;
	}
	/**
	 * 查询所有教师
	 * @return
	 * @throws Exception
	 */
	public String getAllTeacher() throws Exception{
		List<Teachers> teachers = teacherService.getTeachers();
		if(teachers!=null&&teachers.size()>0){
			HttpUtil.getRequset().setAttribute("allteacher", teachers);
		}else {
			teachers = new ArrayList<Teachers>();
			HttpUtil.getRequset().setAttribute("allteacher", teachers);
		}
		return SUCCESS;
	}
	/**
	 * 修改密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changePassword() throws Exception {
		System.out.println("进入方法");
		Teachers teachers = teacherService.getTeacherByPhone("13888888888");
		Set<Students> students = teachers.getStudents();
		for (Students students2 : students) {
			System.out.println(students2.getName());
		}
		return SUCCESS;
	}

	/**
	 * 修改学生信息
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
		Users user = service.getUserByName(students.getStuNum()+"");
		students.setName(stuname);
		students.setStuNum(OtherUtils.getLong(stunum));
		students.setDepartments(studept);
		students.setMajor(stumajor);
		students.setClasses(stucls);
		user.setUserName(stunum);
		boolean updataStudents = studentService.updataStudents(students);
		boolean updataUsers = service.updataUsers(user);
		if(updataStudents&&updataUsers){
			HttpUtil.getResponse().getWriter().print("success");
			return null;
		}
		return null;
	}

	/**
	 * 修改教师信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changeTeaInfo() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String id = requset.getParameter("teacherId");
		String name = requset.getParameter("teacherName");
		String phone = requset.getParameter("teacherPhone");
		Teachers teacherByPhone = teacherService.getTeacherByPhone(phone);
		Teachers teacerById = teacherService.getTeacerById(id);
		HttpServletResponse response = ServletActionContext.getResponse();
		if (teacherByPhone!=null) {
			if(!(teacherByPhone.getPhone().equals(teacerById.getPhone()))){
			response.getWriter().print("1");
			return null;
			}
		}
		Users userByName = service.getUserByName(teacerById.getPhone());
		teacerById.setName(name);
		teacerById.setPhone(phone);
		userByName.setUserName(phone);
		boolean updataUsers = service.updataUsers(userByName);
		boolean updataTeachers = teacherService.updataTeachers(teacerById);
		if (updataTeachers&&updataUsers) {
			response.getWriter().print("success");
			return null;
		}
		return null;
	}

	/**
	 * 添加教师
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
		
		if(psw==null||psw.equals("")){
			psw="111";
		}
		Users users = new Users();
		users.setUserName(phone);
		users.setUserPsw(psw);
		users.setType("2");
		HttpServletResponse response = ServletActionContext.getResponse();
		Teachers teacherByPhone = teacherService.getTeacherByPhone(phone);
		if(teacherByPhone!=null){
			response.getWriter().print("1");
			return null;
		}
		
		boolean saveUser = service.saveUser(users);
		boolean saveTeachers = teacherService.saveTeachers(teachers);
		if(saveTeachers&&saveUser){
			response.getWriter().print("success");
			return null;
		}
		return null;
	}

	/**
	 * 添加学生
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
		if(saveStudent&&saveUser){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.getWriter().print("success");
			return null;
		}
		return null;
	}

	/**
	 * 删除教师
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
		if (deleteTeachers&&deleteUsers) {
			HttpUtil.getResponse().getWriter().print("success");
		}
		return null;
	}

	/**
	 * 删除学生
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteStu() throws Exception {
		String stuId = HttpUtil.getRequset().getParameter("stuId");
		Students students = studentService.getStuById(stuId);
		boolean deleteStudents = studentService.deleteStudents(students);
		Users userByName = service.getUserByName(students.getStuNum()+"");
		boolean deleteUsers = service.deleteUsers(userByName);
		if(deleteStudents&&deleteUsers){
			HttpUtil.getResponse().getWriter().print("success");
		}
		return null;
	}

	/**
	 * 学生选择教师
	 * 
	 * @return
	 * @throws Exception
	 */
	public String choiceTeacher() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		Students student = (Students) HttpUtil.getSession()
				.getAttribute("user");
		Teachers teachers = teacherService.getTeacherByPhone("13888888888");
		student.setTeachers(teachers);
		studentService.updataStudents(student);
		return SUCCESS;
	}

	/**
	 * 教师选择学生
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
