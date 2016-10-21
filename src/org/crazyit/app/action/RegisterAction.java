package org.crazyit.app.action;

import java.util.List;

import org.crazyit.app.dao.LoginRegisterInfo;
import org.crazyit.app.domain.UserInfoPO;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private String username;
	private String password1;
	private String password2;
	private String mess = ERROR;
	private List list;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public void validate(){
		if(this.getUsername()==null||this.getUsername().length()==0){
			addFieldError("username","用户名不能为空");
		}else{
			LoginRegisterInfo info = new LoginRegisterInfo();
			list=info.queryInfo("username", this.getUsername());
			UserInfoPO ui = new UserInfoPO();
			for(int i=0; i<list.size(); i++){
				ui=(UserInfoPO)list.get(i);
				if(ui.getUsername().equals(this.getUsername())){
					addFieldError("username","用户名已经存在");
				}
			}
		}
		if(this.getPassword1()==null||this.getPassword1().length()==0){
			addFieldError("password1","登录密码不能设置为空");
		}else if(this.getPassword2()==null||this.getPassword2().length()==0){
			addFieldError("password2","重复密码不能设置为空");
		}else if(!this.getPassword1().equals(this.getPassword2())){
			addFieldError("password2","两次密码不一致");
		}
	}
	public UserInfoPO userInfo(){
		UserInfoPO info = new UserInfoPO();
		info.setUsername(this.getUsername());
		info.setPassword(this.getPassword1());
		return info;
	}
	public String execute(){
		LoginRegisterInfo lr = new LoginRegisterInfo();
		String ri = lr.saveInfo(userInfo());
		if(ri.equals("success")){
			mess = SUCCESS;
		}
		return mess;
	}
	
}
