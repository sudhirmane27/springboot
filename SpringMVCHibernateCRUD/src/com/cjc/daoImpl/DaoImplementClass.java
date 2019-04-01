package com.cjc.daoImpl;

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

import com.cjc.dao.DaoInterface;
import com.cjc.model.Student;

@Repository
public class DaoImplementClass implements DaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int registerUser(Student s) {
		Session session = sessionFactory.openSession();
		int id = (int) session.save(s);
		session.beginTransaction().commit();
		return id;
	}

	@Override
	public List<Student> getAllStudent() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		query.select(root);
		Query<Student> q = session.createQuery(query);
		List<Student> al = q.getResultList();
		session.beginTransaction().commit();
		return al;

	}

	@Override
	public List<Student> getStudent(String uname, String pass) {

		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		query.select(root).where(builder.equal(root.get("uname"), uname), builder.equal(root.get("pass"), pass));
		Query<Student> q = session.createQuery(query);
		List<Student> al = q.getResultList();
		return al;
	}

	@Override
	public String deleteStudent(int id) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		Transaction tx = session.beginTransaction();
		CriteriaDelete<Student> delet = builder.createCriteriaDelete(Student.class);
		Root<Student> root = delet.from(Student.class);
		// query.select(root).where(builder.equal(root.get("id"),s.getId()));
		// query.where(builder.equal(root.get("id"),s.getId()));
		delet.where(builder.equal(root.get("rollno"), id));
		// System.out.println(delet.where(builder.equal(root.get("id"),s.getId())));
		System.out.println("delet id");
		session.createQuery(delet).executeUpdate();
		tx.commit();
		return "Delete Record Successfully!!!";
	}

	@Override
	public int updateStudent(Student s) {

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		Transaction tx = session.beginTransaction();
		CriteriaUpdate<Student> update = builder.createCriteriaUpdate(Student.class);

		Root<Student> root = update.from(Student.class);

		update.set(root.get("name"), s.getName());
		update.set(root.get("email"), s.getEmail());
		update.set(root.get("lang"), s.getLang());
		update.set(root.get("uname"), s.getUname());
		update.set(root.get("pass"), s.getPass());
		update.set(root.get("country"), s.getCountry());
		update.set(root.get("gender"), s.getGender());

		update.where(builder.equal(root.get("rollno"), s.getRollno()));

		int id = session.createQuery(update).executeUpdate();
		tx.commit();

		return id;
	}

	@Override
	public Student getStudentById(int id) {

		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		query.select(root).where(builder.equal(root.get("rollno"), id));
		Query<Student> q = session.createQuery(query);
		Student s = q.getSingleResult();
		return s;
	}
}
