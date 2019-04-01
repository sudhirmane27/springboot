package com.cjc.daoimplementation;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.daointerface.DaoInterface;
import com.cjc.model.Student;

@Repository
public class DaoImplementation implements DaoInterface{

	@Autowired
	SessionFactory sessionfactory; 
	
	@Override
	public int registerStudent(Student s) {
		
		Session session=sessionfactory.openSession();
		int id = (int) session.save(s);
		session.beginTransaction().commit();
		return id;
	}

	@Override
	public List<Student> getAllStudent() {
		
		Session session=sessionfactory.openSession();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Student> cquery=builder.createQuery(Student.class);
		Root<Student> root=cquery.from(Student.class);
		cquery.select(root);
		Query<Student> query=session.createQuery(cquery);
		List<Student> list=query.getResultList();
		
		return list;	
	}

	@Override
	public List<Student> getOneStudent(String username, String password) {
		
		Session session=sessionfactory.openSession();
		CriteriaBuilder criteriabuilder=session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaquery=criteriabuilder.createQuery(Student.class);
		Root<Student> root=criteriaquery.from(Student.class);
		criteriaquery.select(root).where(criteriabuilder.equal(root.get("username"), username),criteriabuilder.equal(root.get("password"), password));
		Query<Student> query=session.createQuery(criteriaquery);
		List<Student> list=query.getResultList();
		return list;
	}

	@Override
	public Student getElementById(int id) {
		
		Session session=sessionfactory.openSession();
		CriteriaBuilder criteriabuilder=session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaquery=criteriabuilder.createQuery(Student.class);
		Root<Student> root=criteriaquery.from(Student.class);
		criteriaquery.select(root).where(criteriabuilder.equal(root.get("rollno"), id));
		Query<Student> query=session.createQuery(criteriaquery);
		Student s=query.getSingleResult();
		return s;
	}
	
	@Override
	public int updateStudent(Student s) {
		
		Session session=sessionfactory.openSession();
		CriteriaBuilder criteriabuilder=session.getCriteriaBuilder();
		
		Transaction tx=session.beginTransaction();
		CriteriaUpdate<Student> criteriaupdate=criteriabuilder.createCriteriaUpdate(Student.class);
		
		Root<Student> root=criteriaupdate.from(Student.class);		
		
		criteriaupdate.set("username", s.getUsername());
		criteriaupdate.set("password", s.getPassword());
		criteriaupdate.set("address", s.getAddress());
		criteriaupdate.set("mobile", s.getMobile());
		
		criteriaupdate.where(criteriabuilder.equal(root.get("rollno"), s.getRollno()));
		int id=session.createQuery(criteriaupdate).executeUpdate();
		tx.commit();
		return id;
	}
	
	@Override
	public void deleteStudent(int id) {
		
		Session session=sessionfactory.openSession();
		CriteriaBuilder criteriabuilder=session.getCriteriaBuilder();
		Transaction tx=session.beginTransaction();
		
		CriteriaDelete<Student> criteriadelete=criteriabuilder.createCriteriaDelete(Student.class);
		Root<Student> root=criteriadelete.from(Student.class);
		
		criteriadelete.where(criteriabuilder.equal(root.get("rollno"), id));
		
		session.createQuery(criteriadelete).executeUpdate();
		tx.commit();
		
	}



	

	
}
