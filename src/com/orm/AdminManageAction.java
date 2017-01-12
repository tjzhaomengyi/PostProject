package com.orm;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IAdminService;

public class AdminManageAction extends ActionSupport{

	@Resource(name="adminService")
	IAdminService adminService;
	
	private Admin admin;
	
	private Admin getAdmin(){
		return admin;
	}
	
	private void setAdmin(Admin admin){
		this.admin=admin;
	}
	
	
	@Override
	public String execute() throws Exception{
		return super.execute();
		
	}
	//显示个人信息
	public String personalAdminInfo() throws Exception{
		Admin sessionAdmin = (Admin) ActionContext.getContext().getSession().get("admin");
		if(sessionAdmin != null){
			setAdmin(adminService.loadAdmin(sessionAdmin.getId()));
			return SUCCESS;
		}
		return ERROR;
	}

}
