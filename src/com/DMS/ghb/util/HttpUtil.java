package com.DMS.ghb.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class HttpUtil {
	public static HttpServletRequest getRequset() {
		return ServletActionContext.getRequest();
	}

	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	public static String transForUTF(String param) throws Exception{
		param = new String(param.getBytes("ISO8859-1"), "UTF-8");
		return param;
	}
}
