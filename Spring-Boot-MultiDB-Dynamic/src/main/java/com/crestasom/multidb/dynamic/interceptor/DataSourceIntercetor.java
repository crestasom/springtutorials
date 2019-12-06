package com.crestasom.multidb.dynamic.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DataSourceIntercetor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String contextPath = request.getServletContext().getContextPath();

		// /SomeContextPath/publisher
		String prefixPublisher = contextPath + "/publisher";

		// /SomeContextPath/advertiser
		String prefixAdvertiser = contextPath + "/advertiser";

		// /SomeContextPath/publisher/dashboard
		// /SomeContextPath/advertiser/dashboard

		String uri = request.getRequestURI();
		System.out.println("URI:" + uri);

		if (uri.startsWith(prefixPublisher)) {
			request.setAttribute("keyDS", "PUBLISHER_DS");
		}

		else if (uri.startsWith(prefixAdvertiser)) {
			request.setAttribute("keyDS", "ADVERTISER_DS");
		}

		return true;
	}

}