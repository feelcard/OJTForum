package com.kbds.kbforum.core.config.security;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * <pre>
 * 파일명     : SecurityWebApplicationInitializer.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * =================================================================================================
 * 		  	날짜	   		|    	작성자		 	|	                       	내	용		                       |	  
 * =================================================================================================
 * 	  2020. 9. 17.    |	    유한솔      |   웹 컨테이너와 DelegatingFilterProxy를 등록하는데 사용   |	
 * =================================================================================================
 * </pre>
 */

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {



  @Override
  protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {

    FilterRegistration.Dynamic characterEncodingFilter =
        servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());

    characterEncodingFilter.setInitParameter("encoding", "UTF-8");

    characterEncodingFilter.setInitParameter("forceEncoding", "true");

    characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");

  }// EUC-KR을 UTF-8로 인코딩 하는 소스 스프링 시큐리티가 실행되기 전에 해당 소스를 거져서 인코딩과정을 거친다.


}
