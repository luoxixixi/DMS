package com.DMS.ghb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.DMS.ghb.entity.Company;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.service.CompanyService;
import com.DMS.ghb.service.MissionSercive;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.util.HttpUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport {
	private CompanyService service;
	private MissionSercive missionSercive;
	private StudentService studentService;

	/**
	 * 添加实习单位
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveCom() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		HttpSession session = HttpUtil.getSession();
		Students students = (Students) session.getAttribute("user");
		String name = HttpUtil.transForUTF(requset.getParameter("name"));
		String address = HttpUtil.transForUTF(requset.getParameter("address"));
		Company company = new Company();
		company.setAddress(address);
		company.setName(name);
		company.setStuId(students);
		boolean saveCompany = service.saveCompany(company);
		if (saveCompany) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 修改实习单位
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changeCom() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		HttpSession session = HttpUtil.getSession();
		Students students = (Students) session.getAttribute("user");
		String name = HttpUtil.transForUTF(requset.getParameter("name"));
		String address = HttpUtil.transForUTF(requset.getParameter("address"));
		Company company = new Company();
		company.setAddress(address);
		company.setName(name);
		company.setStuId(students);
		boolean updataCompany = service.updataCompany(company);
		if (updataCompany) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	/**
	 * 删除实习单位
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteCom() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String comId = HttpUtil.transForUTF(requset.getParameter("comId"));
		Company company = new Company();
		company.setCompanyId(comId);
		boolean deleteCompany = service.deleteCompany(company);
		if (deleteCompany) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 实习单位导出
	 * 
	 * @return
	 */
	public String except() throws Exception {
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

	public CompanyService getService() {
		return service;
	}

	public void setService(CompanyService service) {
		this.service = service;
	}
}
