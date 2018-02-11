package com.DMS.ghb.entity;

import java.io.Serializable;

public class Company implements Serializable{
	private String companyId;
	private String name;
	private String address;
	private Students stuId;
	

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
