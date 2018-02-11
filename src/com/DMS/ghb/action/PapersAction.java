package com.DMS.ghb.action;

import javax.servlet.http.HttpServletRequest;

import com.DMS.ghb.service.PapersService;
import com.DMS.ghb.util.HttpUtil;
import com.opensymphony.xwork2.ActionSupport;

public class PapersAction extends ActionSupport {
	private PapersService service;

	/**
	 * 添加论文
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
	 * 获得所有
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
	 * 删除
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
	 * 修改
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
	 * 导出论文题目
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
