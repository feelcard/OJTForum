package com.kbds.kbforum.domain.forum.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kbds.kbforum.userstructure.subsidiary.service.SubsidiaryService;

/**
 * <pre>
 * 파일명     : MainResource.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 10. 5.
 * ===============================================================================
 * 		     	날짜	      |    	작성자		 	|		     	       내	용		             |	  
 * ===============================================================================
 * 	     2020. 10. 5.   |	    유한솔     	| 메인페이지 및 게시판페이지 컨트롤러   |	
 * ===============================================================================
 * </pre>
 */

@Controller
public class MainResource {

  @Autowired
  SubsidiaryService subsidiaryService;

  @GetMapping("/")
  public ModelAndView mainPage(ModelAndView mv) {


    // if (subsidiaryService.getAllList() != null)
    // subsidiaryService.removeSubsiCache();

    mv.setViewName("pages/home");

    return mv;

  }

  @GetMapping("/home")
  public ModelAndView homePage(ModelAndView mv) {

    mv.setViewName("pages/home");

    return mv;

  }

}
