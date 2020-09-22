package com.kbds.kbforum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kbds.kbforum.domain.member.MemberService;



/**
 * <pre>
 * 파일명     : LoginResource.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 22.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 22.       |	           유한솔             	|           로그인 컨트롤러             |	
 * ===============================================================================
 * </pre>
 */


@Controller

public class LoginResource {

  @Autowired
  MemberService memberService;

  @GetMapping("/login")
  public ModelAndView login(ModelAndView mv) {
    mv.setViewName("pages/login");

    return mv;

  }

  // @PostMapping("/login")
  // public void loginProcessing(String id, String password) {
  // memberService.loadUserByUsername(id);
  //
  // }



  @GetMapping("/admin")
  public ModelAndView admin(ModelAndView mv, @AuthenticationPrincipal User user) {

    mv.setViewName("pages/admin");

    return mv;

  }

}
