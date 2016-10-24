package com.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.orm.Student;
import com.service.IStudentService;

public class StudentManageAction extends ActionSupport{
	@Resource(name = "studentService")
	IStudentService studentService;
	private Student student;
	private String psw;
	private String newpsw;
	private String confirmpsw;
	
	public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Override
    public String execute() throws Exception {
    	return super.execute();
    }
    
    //显示个人信息
    public String personalStuInfo() throws Exception
    {
    	Student sessionStudent = (Student) ActionContext.getContext().getSession().get("student");
    	if(sessionStudent != null){
    		setStudent(studentService.getStudentByStunum(sessionStudent.getStunum()));
    		return SUCCESS;
    	}
    	return ERROR;
    
    }
    
    //修改个人信息
    public String modifyStuInfo() throws Exception{
    	Student snStudent = (Student) ActionContext.getContext().getSession().get("student");
    	Student s = studentService.getStudentByStunum(snStudent.getStunum());
    	Student temp = getStudent();
    	s.setNickname(temp.getNickname());
    	s.setQq(temp.getQq());
    	s.setEmail(temp.getEmail());
    	
    	if(studentService.modifyStudent(s)){
    		return "modifySuccess";
    	}
    	return ERROR;
    }
    
    //修改密码
	public String MoidfyPsw() throws Exception{
		//获取当前学生信息
		Student sessionStudent = (Student) ActionContext.getContext().getSession().get("student");
		Student s = studentService.getStudentByStunum(sessionStudent.getStunum());
		if(getPsw().equals(s.getPassword())&&getNewpsw().equals(getConfirmpsw())){
			s.setPassword(getNewpsw());
			studentService.modifyStudent(s);
			addActionMessage("密码修改成功");
			return "modifyPswSuccess";
		}
		return ERROR;
	}
	
	 /**
     * @return the psw
     */
    public String getPsw() {
        return psw;
    }

    /**
     * @param psw the psw to set
     */
    public void setPsw(String psw) {
        this.psw = psw;
    }

    /**
     * @return the newPsw
     */
    public String getNewpsw() {
        return newpsw;
    }

    /**
     * @param newPsw the newPsw to set
     */
    public void setNewpsw(String newPsw) {
        this.newpsw = newPsw;
    }

    /**
     * @return the confirmPsw
     */
    public String getConfirmpsw() {
        return confirmpsw;
    }

    /**
     * @param confirmPsw the confirmPsw to set
     */
    public void setConfirmpsw(String confirmPsw) {
        this.confirmpsw = confirmPsw;
    }
	
}
