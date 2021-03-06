package com.DMS.ghb.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.DMS.ghb.entity.Mission;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.service.MissionSercive;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.service.TeacherService;
import com.DMS.ghb.service.UserService;
import com.DMS.ghb.util.HttpUtil;
import com.DMS.ghb.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;

public class MissionAction extends ActionSupport {
	private MissionSercive service;
	private UserService userService;
	private StudentService studentService;
	private TeacherService teacherService;

	/**
	 * 新建任务
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveMission() throws Exception {
		String type = HttpUtil.getRequset().getParameter("type");
		String title = HttpUtil.getRequset().getParameter("title");
		String contest = HttpUtil.getRequset().getParameter("contest");
		Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
				"user");
		Mission mission = new Mission();
		mission.setMissionName(title);
		mission.setMissionContent(contest);
		mission.setMissionType(type);
		mission.setMissionTime(TimeUtil.timeNow());
		mission.setMissionEndTime("----/--/--");
		mission.setMissionStatus("0");
		mission.setTeachers(teachers);
		if (teachers.getType().equals("2")) {
			mission.setLeavel("1");
		} else if (teachers.getType().equals("3")) {
			mission.setLeavel("2");
		} else {
			mission.setLeavel("0");
		}
		boolean saveMission = service.saveMission(mission);
		if (saveMission) {
			HttpUtil.getResponse().getWriter().print("success");
			return null;
		}
		HttpUtil.getResponse().getWriter().print("error");
		return null;

	}

	/**
	 * 查询任务列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getMissionByUser() throws Exception {
		String type = HttpUtil.getRequset().getParameter("type");
		List<Mission> missions = new ArrayList<Mission>();
		if (type.equals("0")) {
			Students student = (Students) HttpUtil.getSession().getAttribute(
					"user");
			Set<Mission> mission = teacherService.getTeacerById(
					student.getTeachers().getTeaId()).getMissions();
			missions = service.getMIssionByUser(student.getTeachers());
			if (missions == null) {
				missions = new ArrayList<Mission>();
			}
			missions.addAll(mission);
		} else if (type.equals("1")) {
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
					"user");
			missions = service.getMIssionByUser(null);
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
		HttpUtil.getRequset().setAttribute("missions", missions);
		return SUCCESS;
	}

	/**
	 * 结束任务
	 * 
	 * @return
	 * @throws Exception
	 */
	public String endMission() throws Exception {
		String missionId = HttpUtil.getRequset().getParameter("missionId");
		Mission mission = service.getMissionById(missionId);
		mission.setMissionEndTime(TimeUtil.timeNow());
		mission.setMissionStatus("9");
		boolean upMission = service.upMission(mission);
		if (upMission) {
			HttpUtil.getResponse().getWriter().print("success");
			return null;
		}
		HttpUtil.getResponse().getWriter().print(ERROR);
		return null;
	}

	public MissionSercive getService() {
		return service;
	}

	public void setService(MissionSercive service) {
		this.service = service;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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
