package com.cjc.serviceinterface;

import java.util.List;

import com.cjc.model.Student;

public interface ServiceInterface {

	public int registerStudent(Student s);
	public List<Student> getAllStudent();
	public List<Student> getOneStudent(String username, String password);
	public Student getElementById(int id);
	public int updateStudent(Student s);
	public void deleteStudent(int id);
}
