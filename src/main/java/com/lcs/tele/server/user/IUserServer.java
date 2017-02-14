package com.lcs.tele.server.user;

import com.lcs.tele.security.model.UserBean;

/**
 * 用户信息接口
 * @author lcs
 */
public interface IUserServer {
	/**
	 * 通过username获取用户信息
	 * @param username
	 * @return <b>UserBean</b>
	 */
	public UserBean getUserInfo(String username);
}
