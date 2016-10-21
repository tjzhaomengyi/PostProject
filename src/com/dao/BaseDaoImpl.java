package com.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mysql.jdbc.Connection;

public class BaseDaoImpl implements BaseDao{

	@Resource(name="hibernateTemplate")
	HibernateTemplate hibernateTemplate;
	
	//加载指定id的对象
	@Override
	public Object loadById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(clazz, id);
	}

	//根据HQL查找指定对象
	@Override
	public Object loadObject(String hql) {
		// TODO Auto-generated method stub
		final String hql1 = hql;
		Object obj = null;
		List list = hibernateTemplate.executeFind(new HibernateCallback(){
			//重写方法
			@Override
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				return query.list();
			}
		});
		if(list.size() > 0){
			obj = list.get(0);
		}
		
		return obj;
	}

	//删除
	@Override
	public void delById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(hibernateTemplate.load(clazz, id));
	}

	//保存或更新
	@Override
	public void saveOrUpdate(Object obj) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(obj);
	}

	//获取全部注意空格
	@Override
	public List listAll(String clazz) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from " + clazz + " as c ");
	}

	
	@Override
	public List listAll(String clazz, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hqlString = "from "+ clazz + " as c order by c.id desc";
		List list = hibernateTemplate.executeFind(
				new HibernateCallback<Object>(){
					@Override
					public Object doInHibernate(Session sn) throws HibernateException,SQLException{
						Query query = sn.createQuery(hqlString);
						query.setMaxResults(pSize);
						query.setFirstResult((pNo - 1) * pSize);
						List result = query.list();
						if(!Hibernate.isInitialized(result)){
							Hibernate.initialize(result);
						}
						return result;
					}
		});
		return list;
	}

	@Override
	public int countAll(String clazz) {
		// TODO Auto-generated method stub
		final String hql = "select count(*) from " + clazz + " as c";
		Long count = (Long)hibernateTemplate.execute(new HibernateCallback<Object>(){

			@Override
			public Object doInHibernate(Session sn) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = sn.createQuery(hql);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
			
		});
		return count.intValue();
		
	}

	@Override
	public List query(String hql) {
		// TODO Auto-generated method stub
		final String hql1 = hql;
		
		return hibernateTemplate.executeFind(new HibernateCallback<Object>(){

			@Override
			public Object doInHibernate(Session sn) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = sn.createQuery(hql1);
				return query.list();
			}
		});		
	}

	@Override
	public List query(String hql, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hqlString = hql;
		List list = hibernateTemplate.executeFind(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session sn) throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = sn.createQuery(hqlString);
						query.setMaxResults(pSize);
						query.setFirstResult((pNo - 1) * pSize);
						List result = query.list();
						if(!Hibernate.isInitialized(result)){
							Hibernate.initialize(result);
						}
						return result;
					}
				});
		return list;
	}

	//根据HQL查询数量
	@Override
	public int countQuery(String hql) {
		// TODO Auto-generated method stub
		final String hql1 = hql;
		Long count = (Long)hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session sn) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = sn.createQuery(hql1);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});
		return count.intValue();
	}

	@Override
	public int update(String hql) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException("Not supported yet.");
	}

	
}
