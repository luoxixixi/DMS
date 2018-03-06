package com.DMS.ghb.entity;

import java.io.Serializable;

public class Papers implements Serializable{
	private String papersId;
	private String name;
	private String message;
	private Students students;
	private Mission mission;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public String getPapersId() {
		return papersId;
	}
	public void setPapersId(String papersId) {
		this.papersId = papersId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Students getStudents() {
		return students;
	}
	public void setStudents(Students students) {
		this.students = students;
	}

	

}
