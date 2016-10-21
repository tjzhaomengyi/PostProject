package com.orm;

import java.util.Date;

public class Reply {

	private Integer id;
	private Admin admin;
	private Student student;
	private Post post;
	private String content;
	private Date publishtime;
	
	public Reply() {
    }

	
    public Reply(Post post, String content) {
        this.post = post;
        this.content = content;
    }
    public Reply(Admin admin, Student student, Post post, String content, Date publishTime) {
       this.admin = admin;
       this.student = student;
       this.post = post;
       this.content = content;
       this.publishtime = publishTime;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    public Post getPost() {
        return this.post;
    }
    
    public void setPost(Post post) {
        this.post = post;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public Date getPublishtime() {
        return this.publishtime;
    }
    
    public void setPublishtime(Date publishTime) {
        this.publishtime = publishTime;
    }
	
	
	
}
