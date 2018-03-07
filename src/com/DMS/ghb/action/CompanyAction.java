package com.DMS.ghb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.DMS.ghb.entity.Company;
import com.DMS.ghb.entity.Mission;
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
		String mId = requset.getParameter("misId");
		String cname = requset.getParameter("cname");
		String caddress = requset.getParameter("caddress");
		String cteacher = requset.getParameter("cteacher");
		String cphone = requset.getParameter("cphone");
		Students stuById = studentService.getStuById(students.getStuId());
		Company company2 = stuById.getCompany();
		if (company2 != null) {
			String id = stuById.getCompany().getMission().getId();
			if (id.equals(mId)) {
				HttpUtil.getResponse().getWriter().print("cpoy");
				return null;
			}
		}
		Mission missionById = missionSercive.getMissionById(mId);
		Company company = new Company();
		company.setAddress(caddress);
		company.setName(cname);
		company.setcTeacher(cteacher);
		company.setcPhonr(cphone);
		company.setMission(missionById);
		company.setStuId(stuById);
		company.setMessage("暂无");
		boolean saveCompany = service.saveCompany(company);
		if (saveCompany) {
			HttpUtil.getResponse().getWriter().print(SUCCESS);
		} else {
			HttpUtil.getResponse().getWriter().print(ERROR);
		}
		return null;
	}

	/**
	 * 修改实习单位
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changeCom() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String cId = requset.getParameter("cId");
		String cname = requset.getParameter("cname");
		String caddress = requset.getParameter("caddress");
		String cteacher = requset.getParameter("cteacher");
		String cphone = requset.getParameter("cphone");
		Company company = service.getCompanyById(cId);
		company.setAddress(caddress);
		company.setName(cname);
		company.setcTeacher(cteacher);
		company.setcPhonr(cphone);
		boolean updataCompany = service.updataCompany(company);
		if (updataCompany) {
			HttpUtil.getResponse().getWriter().print(SUCCESS);
		} else {
			HttpUtil.getResponse().getWriter().print(ERROR);
		}
		return null;
		

	}

	/**
	 * 学生查看问卷作答
	 * @return
	 * @throws Exception
	 */
	public String getCompanyById() throws Exception {
		Students students = (Students) HttpUtil.getSession().getAttribute(
				"user");
		Students stuById = studentService.getStuById(students.getStuId());
		Company company = stuById.getCompany();
		HttpUtil.getRequset().setAttribute("company", company);
		return SUCCESS;
	}
    /**
     * 查看问卷所有答案
     * @return
     * @throws Exception
     */
	public String getCompanyByMisson() throws Exception {
		
		return null;
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
