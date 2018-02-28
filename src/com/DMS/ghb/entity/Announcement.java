package com.DMS.ghb.entity;

import java.io.Serializable;

public class Announcement implements Serializable{
	private String annId;// id
	private String head;// ����
	private String body;// ����
	private String time;// ����ʱ��
	private Teachers teaId;// ������
	private String leavel;
	
	


	public String getLeavel() {
		return leavel;
	}

	public void setLeavel(String leavel) {
		this.leavel = leavel;
	}

	public String getAnnId() {
		return annId;
	}

	public void setAnnId(String annId) {
		this.annId = annId;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Teachers getTeaId() {
		return teaId;
	}

	public void setTeaId(Teachers teaId) {
		this.teaId = teaId;
	}

	@Override
	public String toString() {
		return "Announcement [annId=" + annId + ", head=" + head + ", body="
				+ body + ", time=" + time + ", teaId=" + teaId + ", leavel="
				+ leavel + "]";
	}

	 

}
