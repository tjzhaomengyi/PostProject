package org.crazyit.app.dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.crazyit.app.domain.UserInfoPO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crazyit.app.hibernatectl.HibernateSessionFactory;

public class LoginRegisterInfo {
	private Session session;
	private Transaction transaction;
	private Query query;
	private HibernateSessionFactory HSessFactory;
	
	public LoginRegisterInfo() {
	}
	public String saveInfo(UserInfoPO info){
		String mess = "error";
		HSessFactory = new HibernateSessionFactory();
		session = HSessFactory.getSession();
		try{
			transaction = session.beginTransaction();
			session.save(info);
			transaction.commit();
			mess="success";
			return mess;
		}catch(Exception e){
			message("RegisterInfo.error:"+e);
			e.printStackTrace();
			return null;
		}
		
	}
	private void message(String mess) {
		// TODO Auto-generated method stub
		int type = JOptionPane.YES_NO_OPTION;
		String title = "提示信息";
		JOptionPane.showMessageDialog(null, mess,title,type);
	}
	public List queryInfo(String type,Object value){
		HSessFactory = new HibernateSessionFactory();
		if(HSessFactory != null){
			System.out.println(HSessFactory.toString());
			session = HSessFactory.getSession();
			
		}
		try{
			String hqlsql = "from UserInfoPO as u where u.username=?";
			query=session.createQuery(hqlsql);
			query.setParameter(0, value);
			List list = query.list();
			System.out.print(list.toString());
			transaction=session.beginTransaction();
			transaction.commit();
			return list;
		}catch(Exception e){
			message("LoginRegister类中有异常，异常为"+e);
			e.printStackTrace();
			return null;
		}
	}
	//public String saveInfo(UserInfo){
		
	//}
	
}
