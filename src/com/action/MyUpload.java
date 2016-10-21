package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.orm.Board;
import com.orm.Student;
import com.service.IBoardService;
import com.service.IStudentService;

@SuppressWarnings("serial")
public class MyUpload extends ActionSupport{
	
	@Resource(name="studentService")
	IStudentService studentService;
	
	@Resource(name="boardService")
	IBoardService boardService;
	
	//��װ�ϴ��ļ��������
	private File doc;
	//��װ�ϴ��ļ�������
	private String docContentType;
	//��װ�ϴ��ļ���
	private String docFileName;
	private String path;
	
	public File getDoc(){
		return doc;
	}
	
	public void setDoc(File doc){
		this.doc = doc;
	}
	
	public String getDocContentType(){
		return docContentType;
	}
	
	public void setDocContentType(String doContentType){
		this.docContentType = docContentType;
	}
	
	public String getDocFileName(){
		return docFileName;
	}
	
	public void setDocFileName(String docFilename){
		this.docFileName = docFileName;
	}
	
	public void setPath(String value){
		this.path = value;
	}
	
	@SuppressWarnings("deprecation")
	public String getPath() throws Exception{
		return ServletActionContext.getServletContext().getRealPath(path);
	}
	
	@Override 
	public String execute() throws Exception{
		
		docFileName = getFileName(docFileName);
		FileOutputStream fos = new FileOutputStream(getPath() + "\\" + docFileName);
		FileInputStream fis = new FileInputStream(doc);
		byte[] b = new byte[1024];
		int length = 0;
		while ((length = fis.read(b))>0){
			fos.write(b,0,length);
		}
		//��ͷ��·��д�����ݿ�
		Student stu = (Student) ActionContext.getContext().getSession().get("student");
		if(stu != null){
			Student temp = studentService.getStudentByStuNum(stu.getStunum());
			temp.setPhotopath(getDocFileName());
			studentService.modifyStudent(temp);
		}
		
		return SUCCESS;
	}
	
	public String boardImpUpload() throws Exception{
		docFileName = getFileName(docFileName);
		FileOutputStream fos = new FileOutputStream(getPath() + "\\" + docFileName);
		FileInputStream fis = new FileInputStream(doc);
		byte[] b = new byte[1024];
		int length  = 0;
		while((length = fis.read(b))>0){
			fos.write(b,0,length);
		}
		if(ServletActionContext.getRequest().getParameter("bid")!=null){
			int bid = Integer.valueOf(ServletActionContext.getRequest().getParameter("bid"));
			Board board = boardService.loadBoard(bid);
			board.setBoardImg(getDocFileName());
			if(boardService.saveOrUpdateBoard(board)){
				return SUCCESS;
			}
			return ERROR;
		}
		return ERROR;
	}
	
	
	private String getFileName(String fileName){
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return System.currentTimeMillis()+extension;
	}
	
	
	

}
