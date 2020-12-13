package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Admin;
import com.jbk.entity.Course;
import com.jbk.entity.Student;

@Repository
public class SpringMVCDAO {

	@Autowired
	private SessionFactory sessionFacory;

	public Boolean checkLogin(Admin a) {
		Session session = sessionFacory.openSession();
		Criteria cr = session.createCriteria(Admin.class);
		cr.add(Restrictions.eq("username", a.getUsername()));
		cr.add(Restrictions.eq("password", a.getPassword()));

		List<Admin> listuser = cr.list();
		if (!listuser.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public List<Student> displayStudents() {
		Session session = sessionFacory.openSession();
		Criteria cr = session.createCriteria(Student.class);
		List<Student> stuList = cr.list();
		return stuList;

	}

	public boolean deleteStudent(int id) {
		Session session = sessionFacory.openSession();
		Transaction tx = session.beginTransaction();
		Student st = session.get(Student.class, id);
		System.out.println("deleting studentwith id=" + id);
		session.delete(st);
		tx.commit();

		return true;
	}

	public boolean saveStudent(Student stu) {
		Session session = sessionFacory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(stu);
		tx.commit();
		System.out.println("student saved" + stu.getStudName());

		return true;
	}

	public Student updateStudent(int id) {
		Session session = sessionFacory.openSession();
		Student s = session.get(Student.class, id);

		return s;
	}

	public boolean addUpdatedDetails(Student student) {
		Session session = sessionFacory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
		System.out.println("updated student successfully" + student.getStudName());

		return true;
	}

	public boolean addCourse(Course c) {
		Session session = sessionFacory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();
		System.out.println("updated student successfully" + c.getCourseName());

		return true;
	}

	public List<Course> getCourses() {

		Session session = sessionFacory.openSession();
		Criteria cr = session.createCriteria(Course.class);
		List<Course> l = cr.list();

		return l;
	}

}
