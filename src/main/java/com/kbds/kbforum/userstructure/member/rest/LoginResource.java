package com.kbds.kbforum.userstructure.member.rest;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kbds.kbforum.userstructure.member.service.MemberService;



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
@RequestMapping("/login")
public class LoginResource {

  @Autowired
  MemberService memberService;

  @GetMapping
  public ModelAndView login(ModelAndView mv) {

    mv.setViewName("pages/login");

    return mv;

  }

  @GetMapping("/error/{message:+.}")
  public ModelAndView loginError(ModelAndView mv, @PathVariable String message,
      HttpServletRequest request) {

    System.out.println("meg : " + message);
    mv.addObject("message", message);
    mv.setViewName("pages/error");

    return mv;

  }

  @PostMapping("/error")
  public ModelAndView loginErrorPost(ModelAndView mv, String message, HttpServletRequest request) {
    String meg = (String) request.getAttribute("message");
    System.out.println("meg : " + meg);
    mv.addObject("message", meg);
    mv.setViewName("pages/error");

    return mv;

  }

}
