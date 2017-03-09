package com.lcs.tele.server.controller.user;

import org.springframework.web.servlet.ModelAndView;

import com.lcs.tele.facility.hibernate.model.UserInfo;
import com.lcs.tele.security.model.UserBean;

/**
 * 用户信息接口
 * @author lcs
 */
public interface IUserServer {
	/**
	 * 通过username获取用户信息
	 * @param username 用户名
	 * @return <b>UserInfo</b>
	 */
	public UserInfo getUserInfo(String username);
	
	/**
	 * 注册用户
	 * @param username	用户名
	 * @param password	密码
	 * @return <b>ModelAndView</b>
	 */
	public ModelAndView registerUser(String username,String password);
}
