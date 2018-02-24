package com.DMS.ghb.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.DMS.ghb.entity.Documents;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.DocumentService;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.service.UserService;
import com.DMS.ghb.util.PoiTest;
import com.opensymphony.xwork2.ActionSupport;

public class DocumentAction extends ActionSupport {
	private DocumentService service;
	private UserService userService;
	private StudentService studentService;

	private FileInputStream fileInputStream;

	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	private File file;
	// �ύ������file������
	private String fileFileName;
	// �ύ������file��MIME����
	private String fileContentType;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/**
	 * ��������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importStu() throws Exception {
		System.out.println(fileFileName);
		FileInputStream is = new FileInputStream(file);
		PoiTest test = new PoiTest(fileFileName, is);
		Map<Integer, Map<Integer, Object>> readExcelContent = test.readExcelContent();
		Set<Entry<Integer,Map<Integer,Object>>> entrySet = readExcelContent.entrySet();
		for (Entry<Integer, Map<Integer, Object>> entry : entrySet) {
			Map<Integer, Object> value = entry.getValue();
			Students students = new Students();
			Users users = new Users();
			String num =(String) value.get(0);
			String name =(String) value.get(1);
			String dept =(String) value.get(2);
			String major =(String) value.get(3);
			String cls =(String) value.get(4);
			users.setUserName(num);
			users.setUserPsw(num);
			users.setType("1");
			userService.saveUser(users);
			students.setName(name);
			students.setStuNum(Long.parseLong(num));
			students.setDepartments(dept);
			students.setMajor(major);
			students.setClasses(cls);
			studentService.saveStudent(students);
		}
		System.out.println(readExcelContent);
		return SUCCESS;
	}
	/**
	 * �ļ��ϴ�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String fileUpload() throws Exception {
		Users users = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("suser");// ��ȡ�ϴ���
		// ׼������
		Documents files = new Documents();
		files.setFileName(fileFileName);
		files.setFileContentType(fileContentType);
		files.setUserId(users);
		// ����
		boolean b = service.saveDocuments(files, file);
		if (b) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	/**
	 * ��ѯȫ���ļ�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAllFile() throws Exception {
		List<Documents> files = service.getDocuments();// ��ѯ�ļ�
		if (files != null && files.size() > 0) {
			ServletActionContext.getRequest().setAttribute("files", files);// ���ݻش�
		}
		return SUCCESS;
	}

	/**
	 * ��ѯ�ļ�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getFileByName() throws Exception {
		String search = ServletActionContext.getRequest().getParameter("type");// ��ȡҳ������
		String select = new String(search.getBytes("ISO8859-1"), "UTF-8");// ����
		System.out.println(select);
		Documents files = new Documents();
		files.setFileName(select);
		List<Documents> byName = service.getByName(files);// ��ѯ
		ServletActionContext.getRequest().setAttribute("files", byName);// ���ݻش�
		return SUCCESS;
	}

	/**
	 * �����ļ�
	 */
	public String downLoadFile() throws Exception {
		fileFileName = ServletActionContext.getRequest().getParameter(
				"fileName");// ��ȡ�ļ���
		String fileName = new String(fileFileName.getBytes("ISO8859-1"),
				"UTF-8");// ����
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");// ��ȡ��ʵ·��
		System.out.println(root);
		System.out.println(fileName);
		fileInputStream = new FileInputStream(root + "/" + fileName);// ����ļ�������
		fileFileName = fileFileName.split("---")[1];// �����ļ���
		return SUCCESS;
	}

	public DocumentService getService() {
		return service;
	}

	public void setService(DocumentService service) {
		this.service = service;
	}

	/**
	 * ����ѹ���ļ�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String downZipFile() throws Exception {
		return SUCCESS;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}