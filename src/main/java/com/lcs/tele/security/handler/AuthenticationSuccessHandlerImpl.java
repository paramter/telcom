package com.lcs.tele.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * spring security登录成功响应
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String url;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			HttpServletResponse response, Authentication arg2)
			throws IOException, ServletException {
		logger.debug("登录成功返回成功页面:{}",url);
		response.sendRedirect(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
