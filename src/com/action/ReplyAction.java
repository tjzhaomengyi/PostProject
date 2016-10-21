package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.orm.Post;
import com.orm.Reply;
import com.orm.Student;
import com.service.IPostService;
import com.service.IReplyService;

public class ReplyAction extends ActionSupport{
	
	private int pid;
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid){
		this.pid = pid;
	}
	private Reply reply;
	
	public Reply getReply(){
		return reply;
	}
	
	public void setReply(Reply reply){
		this.reply = reply;
	}
	
	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}
	private List<Reply> replys;
	
	@Resource(name="replyService")
	IReplyService replyService;
	
	@Resource(name="postService")
	IPostService postService;
	
	@Override 
	public String execute() throws Exception{
		return super.execute();
	}
	
	//�ָ�����ѧ�ã����Ӻţ��ظ�����
	public String stuReply() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("pid"));
		Student student = (Student) ActionContext.getContext().getSession().get("session");
		try{
			Post post = postService.loadPost(id);
			replyService.stuReplyPost(student,post,reply);
			//��ȡѧ������
			setReplys(replyService.getReplysByPid(id));
			//����pid�ش����鿴����
			request.setAttribute("pid", id);
			return SUCCESS;
		}catch (Exception e){
			return ERROR;
		}
		
	}
	
	//׼���޸Ļظ�
	public String prepareModifyReply() throws Exception{
		//Ҫ�����޸�ҳ��Ҫ�Ȼ�ȡ�ظ���id��
		int rid = -1;
		if(ServletActionContext.getRequest().getParameter("rid")!=null){
			rid = Integer.valueOf(ServletActionContext.getRequest().getParameter("rid"));
			setReply(replyService.loadReply(rid));
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String modifyReply() throws Exception {
		//Ҫ�޸ĸ�һ���ظ���Ҫ�ύ�޸�
		//Ҫ�ύ�޸���Ҫ�����޸�ҳ��
		//���޸�����
		getReply().setContent(getReply().getContent());
		if(replyService.modifyReply(getReply())){
			return "modifySuccess";
		}
		return ERROR;
	}
	
	public String delReply() throws Exception{
		int rid = -1;
		if(ServletActionContext.getRequest().getParameter("rid")!=null){
			rid = Integer.valueOf(ServletActionContext.getRequest().getParameter("rid"));
			replyService.delReply(rid);
			return "deleteSuccess";
		}
		return ERROR;
	}
	
}
