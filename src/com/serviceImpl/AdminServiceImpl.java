package com.serviceImpl;

import javax.annotation.Resource;

import com.dao.BaseDao;
import com.orm.Admin;
import com.service.IAdminService;

public class AdminServiceImpl implements IAdminService{
	@Resource(name="dao")
	BaseDao dao;
	@Override
	public Admin loadAdmin(int id){
		return (Admin)dao.loadById(Admin.class, id);
	}

}
