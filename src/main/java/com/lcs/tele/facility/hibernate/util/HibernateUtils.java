package com.lcs.tele.facility.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * hibernate工具类
 * @author lcs
 */
public class HibernateUtils {
	private static final SessionFactory sf;
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    static {
    	Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();
        sf = cfg.buildSessionFactory(serviceRegistry);
    }

    private HibernateUtils() {

    }

    public static Session openSession() {
        return sf.openSession();
    }
    
    /**
     * 获取hibernate session对象
     * @return <b>Session</b>
     */
    public static Session getcurrentSession() {
        Session session = threadLocal.get();

        if (session == null) {
            session = sf.openSession();
            threadLocal.set(session);
        }
        return session;
    }
}
