package com.lcs.tele.service.dao.user;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lcs.tele.facility.hibernate.model.UserInfo;
import com.lcs.tele.facility.hibernate.util.HibernateUtils;
import com.lcs.tele.server.dao.user.IUserDao;
import com.lcs.tele.utils.bean.Bean2MapUtils;

/**
 * 用户Dao层服务
 * @author lcs
 */
@Transactional
@Component
public class UserDao implements IUserDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public UserInfo getUserByName(String userName) {
		logger.debug("Dao层查询用户信息by[userName]：{}",userName);
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String querySql = "from UserInfo where userName = '"+userName+"'";
		Query query = session.createQuery(querySql);
		UserInfo userInfo = (UserInfo) query.uniqueResult();
		return userInfo;
	}

	@Override
	public int saveUser(UserInfo userInfo) {
		logger.debug("Dao层保存用户信息。userInfo:{}",Bean2MapUtils.beanToMap(userInfo).toString());
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int num = (int) session.save(userInfo);
		session.getTransaction().commit();
		return num;
	}

	@Override
	public void updateUser(UserInfo userInfo) {
		logger.debug("Dao层更新用户信息。userInfo:{}",Bean2MapUtils.beanToMap(userInfo).toString());
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(userInfo);
		session.getTransaction().commit();
	}
	
}
