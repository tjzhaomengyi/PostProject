package com.serviceImpl;

import javax.annotation.Resource;

import com.dao.BaseDao;
import com.orm.Student;
import com.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
	
	@Resource(name = "dao")
	BaseDao dao;

	@Override
	public Student getStudentByStuNum(String StuNum) {
		Student s = (Student) dao.loadObject("from Student as s where s.stunum = '"+ StuNum + "' ");
		if(s!=null){
			return s;
		}
		return null;
	}

	@Override
	public boolean modifyStudent(Student student) {
		try{
			dao.saveOrUpdate(student);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
}
