package com.kbds.kbforum.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * 파일명     : AdminResource.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 23.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 23.       |	        유한솔                	|      admin controller       |	
 * ===============================================================================
 * </pre>
 */
@Controller
public class AdminResource {

  @GetMapping("/admin")
  public ModelAndView admin(ModelAndView mv, @AuthenticationPrincipal User user) {

    mv.setViewName("pages/admin");

    return mv;

  }

}
