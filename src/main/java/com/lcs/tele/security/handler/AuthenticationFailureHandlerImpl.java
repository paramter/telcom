package com.lcs.tele.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * 登录失败返回
 * @author lcs
 */
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String errorUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, 
			HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		logger.debug("登录校验失败，返回错误页面:{}",errorUrl);
		response.sendRedirect(errorUrl);
	}

	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}
}
