package com.lcs.tele.security.loginservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户登录校验接口
 * @author lcs
 */
public class UserServiceImpl implements UserDetailsService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		logger.debug("开始根据登录名获取登录信息。userName:{}",userName);
		// TODO Auto-generated method stub
		
		return null;
	}
	
}
