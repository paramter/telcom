package com.lcs.tele;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * spring security登录成功响应
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			HttpServletResponse response, Authentication arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
