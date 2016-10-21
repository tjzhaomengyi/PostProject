package org.crazyit.app.dao;

import org.crazyit.app.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserManager {
	
	public static void main(String[] args) throws Exception{
		//实例化Configuration,加载hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
		//以conf创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		//创建Session
		Session sess = sf.openSession();
		//开始事务
		Transaction tx = sess.beginTransaction();
		//创建消息实例
		User user = new User();
		user.setUserid(001);
		user.setNickname("mikemyzhao");
		user.setPassword("admin");
		
		sess.save(user);
		tx.commit();
		sess.close();
		sf.close();
		
	}
	
	
}
