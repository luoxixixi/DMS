package com.DMS.ghb.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Users implements Serializable{
	private String userId;
	private String userName;// ѧ������ѧ�ţ���ʦ�����ֻ���
	private String userPsw;
	private String type;// 1.ѧ��2.��ʦ 3.����4.����
	private Set<Documents> documents;

	public Set<Documents> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Documents> documents) {
		this.documents = documents;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
