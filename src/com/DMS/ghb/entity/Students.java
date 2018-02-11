package com.DMS.ghb.entity;

import java.io.Serializable;

public class Students implements Serializable{
	private String stuId;
	private long stuNum;
	private String name;
	private String years;//±ÏÒµÄê·Ý
	private Papers papers;
	private Company company;
	private String departments;
	private String major;
	private String classes;
	private Teachers teachers;

	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public long getStuNum() {
		return stuNum;
	}
	public void setStuNum(long stuNum) {
		this.stuNum = stuNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public Papers getPapers() {
		return papers;
	}
	public void setPapers(Papers papers) {
		this.papers = papers;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getDepartments() {
		return departments;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public Teachers getTeachers() {
		return teachers;
	}
	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
	

	
	

}
