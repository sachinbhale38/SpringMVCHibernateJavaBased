package com.jbk.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.jbk.entity.Admin;
import com.jbk.entity.Course;
import com.jbk.entity.Student;

@Configuration
public class HibernateConfiguration {

	@Autowired
	private ApplicationContext context;

	@Bean
	public LocalSessionFactoryBean getFacoryBean() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factory.setAnnotatedClasses(Admin.class,Student.class,Course.class);
		return factory;
	}
	
}
