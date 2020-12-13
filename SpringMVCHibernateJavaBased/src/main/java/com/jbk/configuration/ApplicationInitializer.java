package com.jbk.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("ApplicationInitializer getServletConfigClasses()");
		return new Class[] 
				{HibernateConfiguration.class,WebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("ApplicationInitializer getServletMappings( ");
		return new String[] {"/"};
	}

}
