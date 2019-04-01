package com.cjc.dao;

import java.util.List;

import com.cjc.model.Student;

public interface DaoInterface {

	public int registerUser(Student s);

	public List<Student> getAllStudent();
	
	List<Student> getStudent(String uname, String pass);
	
	public Student getStudentById(int id);

	public String deleteStudent(int id);

	public int updateStudent(Student s);
}
