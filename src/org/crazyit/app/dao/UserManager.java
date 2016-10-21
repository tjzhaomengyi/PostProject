package org.crazyit.app.dao;

import org.crazyit.app.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserManager {
	
	public static void main(String[] args) throws Exception{
		//ʵ����Configuration,����hibernate.cfg.xml�ļ�
		Configuration conf = new Configuration().configure();
		//��conf����SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		//����Session
		Session sess = sf.openSession();
		//��ʼ����
		Transaction tx = sess.beginTransaction();
		//������Ϣʵ��
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
