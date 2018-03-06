package com.DMS.ghb.action;

import javax.servlet.http.HttpServletRequest;

import com.DMS.ghb.entity.Mission;
import com.DMS.ghb.entity.Papers;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.service.MissionSercive;
import com.DMS.ghb.service.PapersService;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.util.HttpUtil;
import com.opensymphony.xwork2.ActionSupport;

public class PapersAction extends ActionSupport {
	private PapersService service;
	private MissionSercive missionSercive;
	private StudentService studentService;

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
		Students students = (Students) HttpUtil.getSession().getAttribute("user");
		Students stuById = studentService.getStuById(students.getStuId());
		Papers papers2 = stuById.getPapers();
		if(papers2!=null){
			HttpUtil.getResponse().getWriter().print("cpoy");
			return null;
		}
		Papers papers = new Papers();
		papers.setName(pTitlt);
		papers.setMission(missionById);
		boolean savePaper = service.savePaper(papers);
		if (savePaper) {
			stuById.setPapers(papers);
			boolean updataStudents = studentService.updataStudents(stuById);
			if (updataStudents) {
				HttpUtil.getResponse().getWriter().print(SUCCESS);
			}
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
		requset.getParameter("");
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
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePaper() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * 导出论文题目
	 * 
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
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

}
