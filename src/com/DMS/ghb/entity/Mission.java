package com.DMS.ghb.entity;

import java.io.Serializable;
import java.util.Set;

public class Mission implements Serializable{
	private String id;
	private String missionName;
	private String missionTime;
	private String missionEndTime;
	private String missionContent;//说明
	private String missionType; //1.毕设调查 2. 公司调查
	private String missionStatus;//0 未答题 1 待审核 2 不合格 3 合格 9 结束
	private String leavel;
	private Teachers teachers;
	private Set<Papers> papers;
	private Set<Company> companies;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLeavel() {
		return leavel;
	}
	public void setLeavel(String leavel) {
		this.leavel = leavel;
	}
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	
	public String getMissionTime() {
		return missionTime;
	}
	public void setMissionTime(String missionTime) {
		this.missionTime = missionTime;
	}
	
	public String getMissionEndTime() {
		return missionEndTime;
	}
	public void setMissionEndTime(String missionEndTime) {
		this.missionEndTime = missionEndTime;
	}
	public String getMissionContent() {
		return missionContent;
	}
	public void setMissionContent(String missionContent) {
		this.missionContent = missionContent;
	}
	public String getMissionType() {
		return missionType;
	}
	public void setMissionType(String missionType) {
		this.missionType = missionType;
	}
	public String getMissionStatus() {
		return missionStatus;
	}
	public void setMissionStatus(String missionStatus) {
		this.missionStatus = missionStatus;
	}
	public Teachers getTeachers() {
		return teachers;
	}
	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
	public Set<Papers> getPapers() {
		return papers;
	}
	public void setPapers(Set<Papers> papers) {
		this.papers = papers;
	}
	public Set<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
}
