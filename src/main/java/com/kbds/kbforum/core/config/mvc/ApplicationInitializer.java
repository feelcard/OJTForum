package com.kbds.kbforum.core.config.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.kbds.kbforum.core.config.security.SecurityConfig;

/**
 * <pre>
 * 파일명     : ApplicationInitializer.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ==========================================================================================================
 * 			날짜	      		|    	작성자		 	|		            	내	용		                    |	  
 * ==========================================================================================================
 * 	     2020. 9. 17.     	|	        유한솔               	| DispatherServlet을 생성을 위한 Spring interface 구현체          |	
 * ==========================================================================================================
 * </pre>
 */

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {

    return new Class[] {SecurityConfig.class};

  } // ... other overrides ... }

  @Override
  protected Class<?>[] getServletConfigClasses() {

    // TODO Auto-generated method stub

    return null;

  }

  @Override
  protected String[] getServletMappings() {

    // TODO Auto-generated method stub

    return null;

  }

}
