package com.cjc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.dao.DaoInterface;
import com.cjc.model.Student;
import com.cjc.service.ServiceInterface;


@Service
public class ServiceImplementClass implements ServiceInterface{

	@Autowired 
	private DaoInterface dao;
	
	@Override
	public int registerUser(Student s) {
		return dao.registerUser(s);
	}
	@Override
	public List<Student> getAllStudent() {
		return dao.getAllStudent();	
	}
	@Override
	public List<Student> getStudent(String uname, String pass) {
		return dao.getStudent(uname,pass);
	}
	@Override
	public String deleteStudent(int id) {
		return dao.deleteStudent(id);
		
	}
	@Override
	public int updateStudent(Student s) {
		return dao.updateStudent(s);
	}
	@Override
	public Student getStudentById(int id) {
		 return dao.getStudentById(id);
	}

}
