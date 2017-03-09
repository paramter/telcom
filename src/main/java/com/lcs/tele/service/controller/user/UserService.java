package com.lcs.tele.service.controller.user;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lcs.tele.facility.hibernate.model.UserInfo;
import com.lcs.tele.server.controller.user.IUserServer;
import com.lcs.tele.server.dao.user.IUserDao;

/**
 * 用户信息获取service
 * @author lcs
 */
@Controller
public class UserService implements IUserServer{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserInfo getUserInfo(String username) {
		return userDao.getUserByName(username);
	}

	@Override
	@RequestMapping(value="/register.do", method = {RequestMethod.POST})
	public ModelAndView registerUser(String username, 
			String password) {
		logger.debug("开始注册用户。username:{},password:{}",username,password);
		//初始化ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		int num = 0;
		String errorMsg = null;
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
			UserInfo userInfo = getUserInfo(username);
			if(userInfo != null){
				//已存在用户，更新数据
				userInfo.setPassword(passwordEncoder.encode(password));
				userDao.updateUser(userInfo);
				num = 1;
			}else{
				//不存在，新增用户
				userInfo = new UserInfo();
				userInfo.setUserName(username);
				userInfo.setPassword(passwordEncoder.encode(password));
				num = userDao.saveUser(userInfo);
				errorMsg = "新增用户失败!";
			}
		}
		if(num > 0){
			//更新|新增成功
			modelAndView.setViewName("index");
		}else{
			//更新|新增失败
			modelAndView.setViewName("error");
			modelAndView.addObject("error", errorMsg);
		}
		return modelAndView;
	}
}