package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.dao.SpringMVCDAO;
import com.jbk.entity.Admin;
import com.jbk.entity.Course;
import com.jbk.entity.Student;

@Service
public class SpringMVCService {

	@Autowired
	private SpringMVCDAO dao;

	public Boolean checkLogin(Admin a) {
		System.out.println("checking login credentials....");
		Boolean result = dao.checkLogin(a);

		return result;
	}

	public List<Student> getStudents() {
		return dao.displayStudents();
	}

	public boolean deleteStudent(int id) {
		boolean result=dao.deleteStudent(id);
		return result;
	}

	public boolean saveStudent(Student stu) {
		boolean result=dao.saveStudent(stu);
		return result;
	}

	public Student updateStudent(int id) {
		
		return dao.updateStudent(id);
	}

	public boolean addUpdatedDetails(Student student) {
		boolean result=dao.addUpdatedDetails(student);
		return result;
	}

	public boolean addCourse(Course c) {
		boolean result=dao.addCourse(c);
		return result;
	}

	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return dao.getCourses();
	}

}
