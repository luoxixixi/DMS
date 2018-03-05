package com.DMS.ghb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DMS.ghb.entity.Users;

public class FilterImpl implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 转换类型
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 从session中获取user对象
		Users users = (Users) request.getSession().getAttribute("suser");
		String servletPath = request.getServletPath();// 获取当前的请求路径
		//System.out.println(servletPath);
		/*
		 * /login.jsp /css/bootstrap.min.css /css/font-awesome.css
		 * /css/animate.css /js/jquery.min.js /css/style.css
		 * /js/bootstrap.min.js /img/logo.png
		 */
		if (servletPath.equals("/css/bootstrap.min.css")) {
			chain.doFilter(req, resp);// 继续
			return;
		} else if (servletPath.equals("/css/font-awesome.css")) {
			chain.doFilter(req, resp);// 继续
			return;
		} else if (servletPath.equals("/css/animate.css")) {
			chain.doFilter(req, resp);// 继续
			return;
		} else if (servletPath.equals("/js/jquery.min.js")) {
			chain.doFilter(req, resp);// 继续
			return;
		} else if (servletPath.equals("/css/style.css")) {
			chain.doFilter(req, resp);// 继续
			return;
		} else if (servletPath.equals("/js/bootstrap.min.js")) {
			chain.doFilter(req, resp);// 继续
			return;
		} else if (servletPath.equals("/img/logo.png")) {
			chain.doFilter(req, resp);// 继续
			return;
		} else if (servletPath.equals("/login.jsp")) {// 如果是指定路径
			chain.doFilter(req, resp);// 继续
			return;
		} else {// 如果不是
			if (users != null) {// 判断user时候存在
				chain.doFilter(req, resp);
				return;
			} else {// //如果不存在
				response.sendRedirect("/dms/login.jsp");// 跳转回登录页面
				return;
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
