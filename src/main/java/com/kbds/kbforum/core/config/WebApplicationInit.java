package com.kbds.kbforum.core.config;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * <pre>
 * 파일명     : WebApplicationInit.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	       유한솔       	    | web.xml의 기능과 같음(초기설정)   |	
 * ===============================================================================
 * </pre>
 */

public class WebApplicationInit implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

    context.setConfigLocation("com.kbds.kbforum.core");

    ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));

    dispatcher.setLoadOnStartup(1);

    dispatcher.addMapping("/");

    FilterRegistration.Dynamic charaterEncodingFilter =
        servletContext.addFilter("charaterEncodingFilter", new CharacterEncodingFilter());

    charaterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true,
        "/*");

    charaterEncodingFilter.setInitParameter("encoding", "UTF-8");

    charaterEncodingFilter.setInitParameter("forceEncoding", "true");

  }

}
