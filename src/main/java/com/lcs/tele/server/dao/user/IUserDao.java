package com.lcs.tele.server.dao.user;

import com.lcs.tele.facility.hibernate.model.UserInfo;

/**
 * 用户服务dao层
 * @author lcs
 */
public interface IUserDao {
	/**
	 * 通过用户名获取用户信息
	 * @param userName 用户名
	 * @return <b>UserInfo</b> 查询的用户信息
	 */
	public UserInfo getUserByName(String userName);
	
	/**
	 * 新增用户信息
	 * @param userInfo	用户实体类
	 * @return <b>int</b> 受影响行数
	 */
	public int saveUser(UserInfo userInfo);
	
	/**
	 * 更新用户信息
	 * @param userInfo 用户实体类
	 */
	public void updateUser(UserInfo userInfo);
}
