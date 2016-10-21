package org.crazyit.app.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.crazyit.app.dao.LoginRegisterInfo;
import org.crazyit.app.domain.UserInfoPO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport 
{
	//�����װ���������username��password����
	private String username;
	private String password;
	private String message="error";
	private List list;
	
	//json��android app���
	/*private static final long serialVersionUID = 1l;
	HttpServletRequest request;
	HttpServletResponse response;*/
	
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void validate(){
		System.out.println("Login in..");
		System.out.println("username"+this.getUsername());
		System.out.println("password"+this.getPassword());
		if(this.getUsername() == null || this.getUsername().length() == 0){
			addFieldError("userName","�û�������Ϊ��");
		}else{
			LoginRegisterInfo info = new LoginRegisterInfo();
			System.out.println("LoginRegisterInfo finish");
			System.out.println("username"+this.getUsername());
			list=info.queryInfo("userName",this.getUsername());
			if(list.size()==0){
				addFieldError("userName","���û�δע��!");
			}else{
				UserInfoPO ui = new UserInfoPO();
				int count = 0;
				for(int i=0; i<list.size();i++){
					count++;
					ui=(UserInfoPO)list.get(i);
					if(this.getUsername().equals(ui.getUsername())){
						if(ui.getPassword().equals(this.getPassword())){
							message=SUCCESS;
						}else{
							addFieldError("password","��¼���벻��ȷ");
						}
					}
				}
			}
		}
		
	}
	
	//���崦���û������execute����
	/*public String execute() throws Exception
	{
		//��usernameΪcrazyit.org��passwordΪleegangʱ����¼�ɹ�
		if (getUsername().equals("crazyit.org")
			&& getPassword().equals("leegang") )
		{
			ActionContext.getContext().getSession()
				.put("user" , getUsername());
		return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}*/
	/*@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}*/
	
	/*public void loginForApp(){
		try{
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");
			if (this.request.getParameter("username").equals("123456")) {
				this.response.getWriter().write("what the fuck");
			} else if (this.request.getParameter("username").equals("zhd")) {
				this.response.getWriter().write("hahha");
			} else {
				this.response.getWriter().write("cacaca");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
	
}