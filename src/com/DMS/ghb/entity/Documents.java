package com.DMS.ghb.entity;

import java.io.Serializable;

public class Documents implements Serializable{
	private String docId;// id
	private String fileName;// �ļ���
	private String fileSize;// �ļ���С
	private String upTime;// �ϴ�ʱ��
	private String fileContentType;// �ļ�����
	private String fileType;// �ϴ���
	private String fileStatus;//0 ����� 1 ���ϸ� 2 �ϸ� 7�����ĵ� 8 ��ʦ�ĵ� 9 �����ĵ� 
	private Users userId;



	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

}
