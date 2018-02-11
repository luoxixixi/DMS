package com.DMS.ghb.entity;

import java.io.Serializable;

public class Announcement implements Serializable{
	private String annId;// id
	private String head;// 标题
	private String body;// 内容
	private String time;// 发布时间
	private Teachers teaId;// 发布者



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

	 

}
