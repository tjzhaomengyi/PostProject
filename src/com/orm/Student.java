package com.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * Student generated by hbm2java
 */
public class Student implements java.io.Serializable {


     private Integer id;
     private String stunum;
     private String realname;
     private String nickname;
     private String password;
     private String qq;
     private String email;
     private String major;
     private String classname;
     private String photopath;
     private Set replies = new HashSet(0);
     private Set posts = new HashSet(0);

    public Student() {
    }

	
    public Student(String stunum, String password) {
        this.stunum = stunum;
        this.password = password;
    }
    public Student(String stunum, String realName, String nickName, String password, String qq, String email, String major, String className, String photoPath, Set replies, Set posts) {
       this.stunum = stunum;
       this.realname = realName;
       this.nickname = nickName;
       this.password = password;
       this.qq = qq;
       this.email = email;
       this.major = major;
       this.classname = className;
       this.photopath = photoPath;
       this.replies = replies;
       this.posts = posts;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getStunum() {
        return this.stunum;
    }
    
    public void setStunum(String stunum) {
        this.stunum = stunum;
    }
    public String getRealname() {
        return this.realname;
    }
    
    public void setRealname(String realName) {
        this.realname = realname;
    }
    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickName) {
        this.nickname = nickName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getQq() {
        return this.qq;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    public String getClassname() {
        return this.classname;
    }
    
    public void setClassname(String className) {
        this.classname = className;
    }
    public String getPhotopath() {
        return this.photopath;
    }
    
    public void setPhotopath(String photoPath) {
        this.photopath = photoPath;
    }
    public Set getReplies() {
        return this.replies;
    }
    
    public void setReplies(Set replies) {
        this.replies = replies;
    }
    public Set getPosts() {
        return this.posts;
    }
    
    public void setPosts(Set posts) {
        this.posts = posts;
    }




}


