package com.dao;

import java.io.Serializable;
import java.util.List;

import com.mysql.jdbc.Connection;

public interface BaseDao {
	/*
	 * �����ƶ�ID�ĳ־û�����
	 * 
	 * @param clazz
	 * 
	 * @param id
	 */
	public Object loadById(Class clazz, Serializable id);

	/*
	 * �������������ĳ־û�����
	 * 
	 * @param hql
	 */
	public Object loadObject(String hql);

	/**
	 * ɾ���ƶ�ID�ĳ־û�����
	 * 
	 * @param clazz
	 * @param id
	 * 
	 */
	public void delById(Class clazz, Serializable id);

	/*
	 * ���������ƶ��־û�����
	 * 
	 * @param obj
	 */
	public void saveOrUpdate(Object obj);

	/**
	 * װ���ƶ�������г־û�����
	 * 
	 * @param clazz
	 */
	public List listAll(String clazz);

	/**
	 * ��ҳװ���ƶ�������г־û�����
	 * 
	 * @param clazz
	 * @param pageNo
	 * @param pageSize
	 */
	public List listAll(String clazz, int pageNo, int pageSize);

	/**
	 * ͳ��ָ��������г־û�����
	 * 
	 * @param clazz
	 */
	public int countAll(String clazz);

	/**
	 * ��ѯָ��������������ĳ־û�����
	 * 
	 * @param hql
	 */
	public List query(String hql);

	/**
	 * ��ҳ��ѯָ��������������ĳ־û�����
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 */
	public List query(String hql, int pageNo, int pageSize);

	/**
	 * ͳ��ָ����Ĳ�ѯ���
	 * 
	 * @param hql
	 */
	public int countQuery(String hql);

	/**
	 * �����������ݿ�
	 * 
	 * @param hql
	 */
	public int update(String hql);

	/**
	 * �����ӳػ�ȡJDBC����
	 * 
	 */
	public Connection getConnection();

}
