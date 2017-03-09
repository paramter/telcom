package com.lcs.tele.security.loginservice;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lcs.tele.facility.hibernate.model.UserInfo;
import com.lcs.tele.server.dao.user.IUserDao;

/**
 * 用户登录校验接口
 * @author lcs
 */
@Service
public class UserServiceImpl implements UserDetailsService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("开始根据登录名获取登录信息。userName:{}",username);
		User userBean = null;
		UserInfo userInfo = null;
		if(StringUtils.isNotBlank(username)){
			userInfo = userDao.getUserByName(username);
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			if(userInfo != null){
				logger.debug("username:{},password:{}",userInfo.getUserName(), userInfo.getPassword());
				userBean = new User(userInfo.getUserName(), userInfo.getPassword(), 
						true, true, true, true, authorities);
			}
		}
		return userBean;
	}
	
}
