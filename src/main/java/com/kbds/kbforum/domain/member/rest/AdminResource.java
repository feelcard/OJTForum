package com.kbds.kbforum.domain.member.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/admin")
public class AdminResource {

  // @Secured("ROLE_ADMIN")
  @GetMapping
  public ModelAndView admin(ModelAndView mv) {

    mv.setViewName("pages/admin/admin");

    return mv;

  }

}
