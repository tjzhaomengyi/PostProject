/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.orm.Student;


public interface IStudentService {
    
    public Student getStudentByStunum(String Stunum);
    
    public boolean modifyStudent(Student student);
    
}
