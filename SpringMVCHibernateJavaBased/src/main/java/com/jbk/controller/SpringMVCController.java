package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jbk.entity.Admin;
import com.jbk.entity.Course;
import com.jbk.entity.Student;
import com.jbk.service.SpringMVCService;

@Controller
@ComponentScan("com.jbk")
public class SpringMVCController {

	@Autowired
	private SpringMVCService service;

	@RequestMapping("/loginpage")
	public String login() {
		System.out.println("loginpage .....");
		return "login";
	}

	@RequestMapping("/login")
	public ModelAndView checkLogin(@ModelAttribute Admin a) {
		ModelAndView modelAndView = new ModelAndView();
		Boolean result = service.checkLogin(a);
		System.out.println(result);
		List<Student> listStudent = service.getStudents();
		System.out.println(listStudent);

		if (result) {
			modelAndView.addObject("studentslist", listStudent);
			modelAndView.setViewName("home");

		} else {
			modelAndView.setViewName("login");

		}

		return modelAndView;

	}

	@RequestMapping("/delete")
	public ModelAndView deleteStudent(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		boolean result = service.deleteStudent(id);
		List<Student> listStudent = service.getStudents();
		if (result) {
			mv.addObject("studentslist", listStudent);
			mv.setViewName("home");

		} else {
			mv.setViewName("login");
		}
		return mv;
	}

	@RequestMapping("/addStudents")
	public ModelAndView openAddStudentPage() {
		ModelAndView mv =new ModelAndView();
		List<Course> l=service.getCourses();
		if (!l.isEmpty()) {
			mv.addObject("courseList", l);
			mv.setViewName("addStudents");
			
		}
		return mv;
	}

	@RequestMapping("/addCourse")
	public String openAddCoursePage() {
		return "addCourse";
	}

	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student stu) {
		System.out.println(stu.getStudName());
		ModelAndView mv = new ModelAndView();
		boolean result = service.saveStudent(stu);
		System.out.println(result);
		List<Student> listStudent = service.getStudents();
		if (result) {
			mv.addObject("studentslist", listStudent);
			mv.setViewName("home");

		} else {
			mv.setViewName("login");
		}
		return mv;

	}

	@RequestMapping("/update")
	public ModelAndView updateStudent(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		Student s = service.updateStudent(id);
		List<Course> l=service.getCourses();
		if (!s.equals(null)) {
			mv.addObject("courseList", l);
			mv.addObject("student", s);
			mv.setViewName("edit");
		} else {
			mv.setViewName("home");

		}
		return mv;

	}

	@RequestMapping("edit")
	public ModelAndView editStudent(@ModelAttribute Student student) {
		ModelAndView mv = new ModelAndView();
		System.out.println("id:" + student.getStudId() + " and name:" + student.getStudName());
		boolean result = service.addUpdatedDetails(student);
		List<Student> listStudent = service.getStudents();
		if (result) {
			mv.addObject("studentslist", listStudent);
			mv.setViewName("home");

		} else {
			mv.setViewName("login");
		}
		return mv;
	}

	@RequestMapping("addCourses")
	public ModelAndView addCourse(@ModelAttribute Course c) {
		ModelAndView mv = new ModelAndView();
		boolean result = service.addCourse(c);
		List<Student> listStudent = service.getStudents();
		if (result) {
			mv.addObject("studentslist", listStudent);
			mv.setViewName("home");

		} else {
			mv.setViewName("login");
		}
		return mv;
	}
	@RequestMapping("listCourse")
	public ModelAndView getCourses() {
		ModelAndView mv=new ModelAndView();
		List<Course> l=service.getCourses();
		if (!l.isEmpty()) {
			mv.addObject("courseList", l);
			mv.setViewName("listcourses");
			
		}
		else {
			mv.setViewName("login");
		}
		return mv;
	}

}