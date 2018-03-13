package com.DMS.ghb.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.DMS.ghb.entity.Company;
import com.DMS.ghb.entity.EntityForExport;
import com.DMS.ghb.entity.Mission;
import com.DMS.ghb.entity.Papers;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.MissionSercive;
import com.DMS.ghb.service.PapersService;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.service.TeacherService;
import com.DMS.ghb.util.HttpUtil;
import com.DMS.ghb.util.PoiTest;
import com.opensymphony.xwork2.ActionSupport;

public class PapersAction extends ActionSupport {
	private PapersService service;
	private MissionSercive missionSercive;
	private StudentService studentService;
	private TeacherService teacherService;

	/**
	 * 添加论文
	 * 
	 * @return
	 * @throws Exception
	 */
	public String savepaper() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String pTitlt = requset.getParameter("title");
		String missionId = requset.getParameter("misId");
		Mission missionById = missionSercive.getMissionById(missionId);
		Students students = (Students) HttpUtil.getSession().getAttribute(
				"user");
		Students stuById = studentService.getStuById(students.getStuId());
		Papers papers2 = service.getStuPaper(stuById.getStuId(), missionId);
		if (papers2 != null) {
			HttpUtil.getResponse().getWriter().print("cpoy");
			return null;
		}
		Papers papers = new Papers();
		papers.setName(pTitlt);
		papers.setMission(missionById);
		papers.setStudents(stuById);
		papers.setMessage("暂无");
		boolean savePaper = service.savePaper(papers);
		if (savePaper) {
			HttpUtil.getResponse().getWriter().print(SUCCESS);
		} else {
			HttpUtil.getResponse().getWriter().print(ERROR);
		}
		return null;
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePaper() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String id = requset.getParameter("pId");
		String pTitlt = requset.getParameter("title");
		Papers paperById = service.getPaperById(id);
		paperById.setName(pTitlt);
		boolean updataPaper = service.updataPaper(paperById);
		if (updataPaper) {
			HttpUtil.getResponse().getWriter().print(SUCCESS);
		} else {
			HttpUtil.getResponse().getWriter().print(ERROR);
		}
		return null;
	}

	/**
	 * 获得所有
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAllpaper() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String missionId = requset.getParameter("mId");
		Users users = (Users) HttpUtil.getSession().getAttribute("suser");
		List<Papers> papers = new ArrayList<Papers>();
		if (users.getType().equals("2")) {// 教师
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
					"user");
			Teachers teacerById = teacherService.getTeacerById(teachers
					.getTeaId());
			Set<Students> students = teacerById.getStudents();
			for (Students students2 : students) {
				Papers papers2 = service.getStuPaper(students2.getStuId(), missionId);
				if (papers2 != null) {
					papers.add(papers2);
				}
			}
		} else if (users.getType().equals("3")) {
			Set<Papers> papers2 = missionSercive.getMissionById(missionId)
					.getPapers();
			if (papers2 != null) {
				papers.addAll(papers2);
			}

		}
		HttpUtil.getRequset().setAttribute("papers", papers);
		HttpUtil.getRequset().setAttribute("mId", missionId);
		return SUCCESS;
	}

	/**
	 * 查看单个问题
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getPaperById() throws Exception {
		Students students = (Students) HttpUtil.getSession().getAttribute(
				"user");
		String mId = HttpUtil.getRequset().getParameter("misId");
		Students stuById = studentService.getStuById(students.getStuId());
		Papers papers = service.getStuPaper(stuById.getStuId(), mId);
		System.out.println(papers);
		HttpUtil.getRequset().setAttribute("papers", papers);
		return SUCCESS;

	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deletepaper() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * 审批
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changePMessage() throws Exception {
		String cId = HttpUtil.getRequset().getParameter("cId");
		String message = HttpUtil.getRequset().getParameter("message");
		Papers paperById = service.getPaperById(cId);
		paperById.setMessage(message);
		boolean updataPaper = service.updataPaper(paperById);
		if (updataPaper) {
			HttpUtil.getResponse().getWriter().print(SUCCESS);
		} else {
			HttpUtil.getResponse().getWriter().print(ERROR);
		}
		return null;
	}

	/**
	 * 导出论文题目
	 * 
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String missionId = requset.getParameter("mId");
		Users users = (Users) HttpUtil.getSession().getAttribute("suser");
		List<Papers> papers = new ArrayList<Papers>();
		if (users.getType().equals("2")) {// 教师
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
					"user");
			Teachers teacerById = teacherService.getTeacerById(teachers
					.getTeaId());
			Set<Students> students = teacerById.getStudents();
			for (Students students2 : students) {
				Papers papers2 = service.getStuPaper(students2.getStuId(), missionId);
				if (papers2 != null) {
					papers.add(papers2);
				}
			}
		} else if (users.getType().equals("3")) {
			Set<Papers> papers2 = missionSercive.getMissionById(missionId)
					.getPapers();
			if (papers2 != null) {
				papers.addAll(papers2);
			}

		}
		List<EntityForExport> entity = new ArrayList<EntityForExport>();
		for (Papers papers2 : papers) {
			entity.add(new EntityForExport(papers2.getStudents(), papers2, null));
		}
		HSSFWorkbook exPaper = PoiTest.exPaper(entity);
		ServletOutputStream os = HttpUtil.getResponse().getOutputStream();
		try {
			exPaper.write(os);
		} catch (Exception e) {
		} finally {
			os.close();
		}
		return null;
	}

	public MissionSercive getMissionSercive() {
		return missionSercive;
	}

	public void setMissionSercive(MissionSercive missionSercive) {
		this.missionSercive = missionSercive;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public PapersService getService() {
		return service;
	}

	public void setService(PapersService service) {
		this.service = service;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

}
