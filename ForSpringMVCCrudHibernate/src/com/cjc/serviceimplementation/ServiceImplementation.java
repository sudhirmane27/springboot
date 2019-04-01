package com.cjc.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.daointerface.DaoInterface;
import com.cjc.model.Student;
import com.cjc.serviceinterface.ServiceInterface;

@Service
public class ServiceImplementation implements ServiceInterface{

	@Autowired
	DaoInterface di;
	
	@Override
	public int registerStudent(Student s) {
		
		int id=di.registerStudent(s);
		return id;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list=di.getAllStudent();
		return list;
	}


	@Override
	public List<Student> getOneStudent(String username, String password) {
		
		List<Student> list=di.getOneStudent(username, password);
		return list;
	}
	
	@Override
	public void deleteStudent(int id) {
		
		di.deleteStudent(id);
		
	}

	@Override
	public Student getElementById(int id) {
		
		Student s=di.getElementById(id);
		return s;
	}

	@Override
	public int updateStudent(Student s) {
		int id=di.updateStudent(s);
		return id;
	}




	
}
