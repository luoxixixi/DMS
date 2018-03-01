package com.DMS.ghb.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Teachers implements Serializable{
	private String teaId;
	private String name;
	private String phone;
	private String teaInfo;
	private String major;
	Set<Mission> missions;
	Set<Students> students;
	Set<Announcement> announcements;

	public String getTeaInfo() {
		return teaInfo;
	}

	public void setTeaInfo(String teaInfo) {
		this.teaInfo = teaInfo;
	}


	

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}



	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Students> getStudents() {
		return students;
	}

	public void setStudents(Set<Students> students) {
		this.students = students;
	}

	public Set<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(Set<Announcement> announcements) {
		this.announcements = announcements;
	}

	public Set<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}

	
}
