package com.crazyit.app.hibernatectl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private SessionFactory sessionFactory;
	public HibernateSessionFactory(){
		
	}
	public SessionFactory config(){
		try{
			Configuration configuration = new Configuration();
			
			Configuration configure = configuration.configure();
			System.out.println("getaconfiguration "+configure.toString());
			SessionFactory sf = configure.buildSessionFactory();
			System.out.println("get SessionFactory: "+sf.toString());
			return sf;
		}catch(Exception e){
			e.getMessage();
			return null;
		}
	}
	public Session getSession(){
		sessionFactory=config();
//		if(sessionFactory != null){
	    System.out.println("getasessionFactory"+sessionFactory.toString());
		Session sess = sessionFactory.openSession();
		System.out.println("Got a session "+sess.toString());
		return sess;
//		}
//		else
//			return null;
	}

}
