package com.cjc.service;

import java.util.List;

import com.cjc.model.Student;

public interface ServiceInterface {

	public int registerUser(Student s);

	public List<Student> getAllStudent();

	List<Student> getStudent(String uname, String pass);

	public String deleteStudent(int id);

	public int updateStudent(Student s);

	public Student getStudentById(int id);

	
	
}
