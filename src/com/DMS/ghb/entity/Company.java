package com.DMS.ghb.entity;

import java.io.Serializable;

public class Company implements Serializable {
	private String companyId;
	private String name;
	private String address;
	private String cTeacher;
	private String cPhonr;
	private Students stuId;
	private Mission mission;

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public String getcTeacher() {
		return cTeacher;
	}

	public void setcTeacher(String cTeacher) {
		this.cTeacher = cTeacher;
	}

	public String getcPhonr() {
		return cPhonr;
	}

	public void setcPhonr(String cPhonr) {
		this.cPhonr = cPhonr;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Students getStuId() {
		return stuId;
	}

	public void setStuId(Students stuId) {
		this.stuId = stuId;
	}

}
