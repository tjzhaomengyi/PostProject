package com.orm;

import java.util.HashSet;
import java.util.Set;

public class Admin {
	
	private Integer id;
	private String account;
	private String password;
	private int qx;
	private String nickname;
	private String name;
	private String photopath;
	private Set posts = new HashSet(0);
	private Set replies = new HashSet(0);
	private Set boards = new HashSet(0);
	
	public Admin(){
		
	}
	
	public Admin(String account, String password, int qx) {
        this.account = account;
        this.password = password;
        this.qx = qx;
    }
    public Admin(String account, String password, int qx, String nickName, String name, String photoPath, Set posts, Set replies, Set boards) {
       this.account = account;
       this.password = password;
       this.qx = qx;
       this.nickname = nickName;
       this.name = name;
       this.photopath = photoPath;
       this.posts = posts;
       this.replies = replies;
       this.boards = boards;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAccount() {
        return this.account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public int getQx() {
        return this.qx;
    }
    
    public void setQx(int qx) {
        this.qx = qx;
    }
    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickName) {
        this.nickname = nickName;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPhotopath() {
        return this.photopath;
    }
    
    public void setPhotopath(String photoPath) {
        this.photopath = photoPath;
    }
    public Set getPosts() {
        return this.posts;
    }
    
    public void setPosts(Set posts) {
        this.posts = posts;
    }
    public Set getReplies() {
        return this.replies;
    }
    
    public void setReplies(Set replies) {
        this.replies = replies;
    }
    public Set getBoards() {
        return this.boards;
    }
    
    public void setBoards(Set boards) {
        this.boards = boards;
    }


}



    

