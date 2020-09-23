package com.kbds.kbforum.core.config.security;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 파일명     : CustomAuthenticationFailureHandler.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 23.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 23.       |	        유한솔                	|      인증실패 핸들링 클래스              |	
 * ===============================================================================
 * </pre>
 */

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {

    request.setCharacterEncoding("UTF-8");

    request.setAttribute("message", exception.getMessage());

    RequestDispatcher dispatcher = request.getRequestDispatcher("/login/error");

    dispatcher.forward(request, response);

  }

}
