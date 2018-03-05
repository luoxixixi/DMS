package com.DMS.ghb.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DMS.ghb.entity.Documents;
import com.DMS.ghb.entity.Students;
import com.DMS.ghb.entity.Teachers;
import com.DMS.ghb.entity.Users;
import com.DMS.ghb.service.DocumentService;
import com.DMS.ghb.service.StudentService;
import com.DMS.ghb.service.UserService;
import com.DMS.ghb.util.Doc2HtmlUtil;
import com.DMS.ghb.util.HttpUtil;
import com.DMS.ghb.util.PoiTest;
import com.DMS.ghb.util.ZIPUtil;
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
	// 提交过来的file的名字
	private String fileFileName;
	// 提交过来的file的MIME类型
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
	 * 导入数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importStu() throws Exception {
		FileInputStream is = new FileInputStream(file);
		PoiTest test = new PoiTest(fileFileName, is);
		Map<Integer, Map<Integer, Object>> readExcelContent = test
				.readExcelContent();
		Set<Entry<Integer, Map<Integer, Object>>> entrySet = readExcelContent
				.entrySet();
		for (Entry<Integer, Map<Integer, Object>> entry : entrySet) {
			Map<Integer, Object> value = entry.getValue();
			Students students = new Students();
			Users users = new Users();
			String num = (String) value.get(0);
			String name = (String) value.get(1);
			String dept = (String) value.get(2);
			String major = (String) value.get(3);
			String cls = (String) value.get(4);
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
		return SUCCESS;
	}

	/**
	 * 文件上传
	 * 
	 * @return
	 * @throws Exception
	 */
	public String fileUpload() throws Exception {
		Users users = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("suser");// 获取上传者
		String type = users.getType();
		String name = "";
		String realName = "";
		if (type.equals("1")) {
			Students students = (Students) HttpUtil.getSession().getAttribute(
					"user");
			name = students.getName();
			realName = "学生文件\\" + students.getDepartments() + "\\"
					+ students.getMajor() + "\\" + students.getClasses();
		} else if (type.equals("2")) {
			Teachers teachers = (Teachers) HttpUtil.getSession().getAttribute(
					"user");
			name = teachers.getName();
			realName = "教师文件\\" + teachers.getName();
		} else if (type.equals("3")) {
			name = users.getUserName();
			realName = "主任文件";
		}
		// 准备数据
		Documents files = new Documents();
		files.setFileName(fileFileName);
		files.setFileContentType(fileContentType);
		files.setFileType(name);
		files.setUserId(users);
		files.setPath(realName);
		if (type.equals("1")) {
			files.setFileStatus("0");
		} else if (type.equals("2")) {
			files.setFileStatus("8");
		} else if (type.equals("3")) {
			files.setFileStatus("9");
		} else {
			files.setFileStatus("7");
		}
		// 保存
		boolean b = service.saveDocuments(files, file);
		if (b) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	/**
	 * 查询全部文件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAllFile() throws Exception {
		List<Documents> files = service.getDocuments();// 查询文件
		if (files != null && files.size() > 0) {
			ServletActionContext.getRequest().setAttribute("files", files);// 数据回传
			System.out.println(files.get(0).getPath());
		} else {
			files = new ArrayList<Documents>();
			ServletActionContext.getRequest().setAttribute("files", files);// 数据回传
		}
		return SUCCESS;
	}

	/**
	 * 查询文件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getFileByName() throws Exception {
		String search = ServletActionContext.getRequest().getParameter("type");// 获取页面数据
		String select = new String(search.getBytes("ISO8859-1"), "UTF-8");// 编码
		System.out.println(select);
		Documents files = new Documents();
		files.setFileName(select);
		List<Documents> byName = service.getByName(files);// 查询
		ServletActionContext.getRequest().setAttribute("files", byName);// 数据回传
		return SUCCESS;
	}

	/**
	 * 下载文件
	 */
	public String downLoadFile() throws Exception {
		String fileId = HttpUtil.getRequset().getParameter("fileId");
		Documents document = service.getDocumentsById(fileId);
		fileFileName = document.getFileName();
		String path = document.getPath();
		String fileName = document.getFileContentType();
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");// 获取真实路径
		System.out.println(root);
		System.out.println(fileName);
		fileInputStream = new FileInputStream(root + "/" + path + "/"
				+ fileName);// 或得文件输入流
		return SUCCESS;
	}

	/**
	 * 删除文件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deletefile() throws Exception {

		String fileId = HttpUtil.getRequset().getParameter("fileId");

		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");// 获取真实路径

		Documents documentsById = service.getDocumentsById(fileId);
		boolean deleteDocuments = service.deleteDocuments(documentsById);
		System.out.println(deleteDocuments);
		if (deleteDocuments) {
			String path = root + "\\" + documentsById.getPath() + "\\"
					+ documentsById.getFileContentType();
			System.out.println(path);
			File file = new File(path);
			boolean delete = file.delete();
			if (delete) {
				HttpUtil.getResponse().getWriter().print("success");
			}
		}
		return null;

	}

	public String getHis() throws Exception {

		return SUCCESS;
	}

	/**
	 * 归档文件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String historyFile() throws Exception {
		List<Documents> documents = service.getDocuments();
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");// 获取真实路径
		ZIPUtil.creatZIP(documents, root);
		return null;

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showFile() throws Exception {
		String docId = HttpUtil.getRequset().getParameter("docId");
		Documents documentsById = service.getDocumentsById(docId);

		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");// 获取真实路径
		String path = root + "\\" + documentsById.getPath() + "\\"
				+ documentsById.getFileContentType();
		FileInputStream stream = new FileInputStream(path);
		String toFilePath = root + "\\tempPDF";
		String[] split = documentsById.getFileContentType().split("\\.");
		String type = split[split.length - 1];
		Doc2HtmlUtil t = Doc2HtmlUtil.getDoc2HtmlUtilInstance();
		System.out.println(type);
		String PDFname = t.file2pdf(stream, toFilePath, type);
		if (PDFname == null) {
			HttpUtil.getResponse().getWriter().print("error");
			return null;
		}
		HttpServletRequest requset = HttpUtil.getRequset();
		String responseStr = "http://" + requset.getServerName() + ":"
				+ requset.getServerPort() + requset.getContextPath()
				+ "/upload/tempPDF/" + PDFname;
		HttpUtil.getResponse().getWriter().print(responseStr);
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteFile2() throws Exception {
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");// 获取真实路径
		String url = HttpUtil.getRequset().getParameter("req");
		String[] split = url.split("/");
		String pdfName= split[split.length-1];
		File file = new File(root+"/tempPDF/"+pdfName);
		file.delete();
		return null;
	}

	/**
	 * 下载压缩文件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String downZipFile() throws Exception {
		return SUCCESS;
	}

	public DocumentService getService() {
		return service;
	}

	public void setService(DocumentService service) {
		this.service = service;
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
