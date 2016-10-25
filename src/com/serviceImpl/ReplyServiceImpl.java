package com.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.dao.BaseDao;
import com.orm.Post;
import com.orm.Reply;
import com.orm.Student;
import com.service.IReplyService;

public class ReplyServiceImpl implements IReplyService{

	@Resource(name="dao")
	BaseDao dao;

	@Override
	public Reply loadReply(int rid) {
		return (Reply) dao.loadById(Reply.class, rid);
	}

	@Override
	public List<Reply> getReplysByPid(int pid) {
		try{
		List<Reply> replies = (List<Reply>) dao.loadObject("from Reply as r where r.pid='"+pid+"'");
		return replies;
	}catch(Exception e){
		return null;
		}
	}

	@Override
	public boolean stuReplyPost(Student student, Post post, Reply reply) {
		try{
			reply.setStudent(student);
			reply.setPost(post);
			reply.setContent(reply.getContent());
			reply.setPublishtime(new Date());
			dao.saveOrUpdate(reply);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	@Override
	public boolean modifyReply(Reply reply) {
		try{
			dao.saveOrUpdate(reply);
			return true;
		} catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean delReply(int rid) {
		// TODO Auto-generated method stub
		try{
			dao.delById(Reply.class, rid);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
		
	
}
