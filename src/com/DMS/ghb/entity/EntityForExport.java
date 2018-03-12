package com.DMS.ghb.entity;

public class EntityForExport {
	private Students students;
	private Papers papers;
	private Company company;
	public EntityForExport(Students students, Papers papers, Company company) {
		this.students = students;
		this.papers = papers;
		this.company = company;
	}
	public Students getStudents() {
		return students;
	}
	public void setStudents(Students students) {
		this.students = students;
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
}
