package com.DMS.ghb.action;

import javax.servlet.http.HttpServletRequest;

import com.DMS.ghb.service.PapersService;
import com.DMS.ghb.util.HttpUtil;
import com.opensymphony.xwork2.ActionSupport;

public class PapersAction extends ActionSupport {
	private PapersService service;

	/**
	 * �������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String savepaper() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * �������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAllpaper() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * ɾ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deletepaper() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * �޸�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePaper() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	/**
	 * ����������Ŀ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		HttpServletRequest requset = HttpUtil.getRequset();
		requset.getParameter("");
		return SUCCESS;
	}

	public PapersService getService() {
		return service;
	}

	public void setService(PapersService service) {
		this.service = service;
	}

}
