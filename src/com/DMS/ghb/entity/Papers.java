package com.DMS.ghb.entity;

import java.io.Serializable;

public class Papers implements Serializable{
	private String papersId;
	private String name;
	private Students students;

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
