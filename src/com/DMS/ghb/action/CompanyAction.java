package com.DMS.ghb.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.DMS.ghb.entity.Company;
import com.DMS.ghb.entity.EntityForExport;
import com.DMS.ghb.entity.Mission;
import com.DMS.ghb.entity.Papers;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.CompanyService;
import com.DMS.ghb.service.MissionSercive;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.service.TeacherService;
import com.DMS.ghb.util.HttpUtil;
import com.DMS.ghb.util.PoiTest;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport {
	private CompanyService service;
	private MissionSercive missionSercive;
	private StudentService studentService;
	private TeacherService teacherService;


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
		HttpServletRequest requset = HttpUtil.getRequset();
		String missionId = requset.getParameter("mId");
		Users users = (Users) HttpUtil.getSession().getAttribute("suser");
		List<Company> companies = new ArrayList<Company>();
		if(users.getType().equals("2")){//教师
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute("user");
			Teachers teacerById = teacherService.getTeacerById(teachers.getTeaId());
			Set<Students> students = teacerById.getStudents();
			for (Students students2 : students) {
				 Company company = students2.getCompany();
				if(company!=null){
					companies.add(company);
				}
			}
		}else if (users.getType().equals("3")) {
			 Set<Company> companies2 = missionSercive.getMissionById(missionId).getCompanies();
			if(companies2!=null){
				companies.addAll(companies2);
			}
		}
		HttpUtil.getRequset().setAttribute("companies", companies);
		HttpUtil.getRequset().setAttribute("mId", missionId);
		return SUCCESS;
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
	 * 审批
	 * @return
	 * @throws Exception
	 */
	public String changeCMessage() throws Exception{
		String cId = HttpUtil.getRequset().getParameter("cId");
		String message = HttpUtil.getRequset().getParameter("message");
		Company companyById = service.getCompanyById(cId);
		companyById.setMessage(message);
		boolean updataCompany = service.updataCompany(companyById);
		if (updataCompany) {
			HttpUtil.getResponse().getWriter().print(SUCCESS);
		}else {
			HttpUtil.getResponse().getWriter().print(ERROR);
		}
		return null;
	}
	
	/**
	 * 实习单位导出
	 * 
	 * @return
	 */
	public String except() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		String missionId = requset.getParameter("mId");
		Users users = (Users) HttpUtil.getSession().getAttribute("suser");
		List<Company> companies = new ArrayList<Company>();
		if(users.getType().equals("2")){//教师
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute("user");
			Teachers teacerById = teacherService.getTeacerById(teachers.getTeaId());
			Set<Students> students = teacerById.getStudents();
			for (Students students2 : students) {
				 Company company = students2.getCompany();
				if(company!=null){
					companies.add(company);
				}
			}
		}else if (users.getType().equals("3")) {
			 Set<Company> companies2 = missionSercive.getMissionById(missionId).getCompanies();
			if(companies2!=null){
				companies.addAll(companies2);
			}
		}
		List<EntityForExport> entity = new ArrayList<EntityForExport>();
		for (Company company : companies) {
			entity.add(new EntityForExport(company.getStuId(), null, company));
		}
		HSSFWorkbook exCompany = PoiTest.exCompany(entity);
		ServletOutputStream os = HttpUtil.getResponse().getOutputStream();
		try {
			exCompany.write(os);
		} catch (Exception e) {
		}finally{
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

	public CompanyService getService() {
		return service;
	}

	public void setService(CompanyService service) {
		this.service = service;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
}
