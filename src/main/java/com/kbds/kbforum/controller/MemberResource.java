package com.kbds.kbforum.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kbds.kbforum.domain.authority.AuthorityService;
import com.kbds.kbforum.domain.member.MemberDTO;
import com.kbds.kbforum.domain.member.MemberService;
import com.kbds.kbforum.domain.subsidiary.Subsidiary;
import com.kbds.kbforum.domain.subsidiary.SubsidiaryService;

/**
 * <pre>
 * 파일명     : MemberResource.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	        유한솔       	    |      회원CRUD 및 인증 컨트롤러      |	
 * ===============================================================================
 * </pre>
 */

@Controller
public class MemberResource {

  @Autowired
  MemberService memberService;
  @Autowired
  SubsidiaryService subsidiaryService;
  @Autowired
  AuthorityService authorityService;


  @PostMapping("/member")
  public ModelAndView registerProcessingMember(ModelAndView mv,
      @ModelAttribute("member") MemberDTO memberDTO, String subsiName) {

    System.out.println(memberDTO);
    memberDTO.setSubsi(subsidiaryService.getSubsiByName(subsiName));

    memberService.save(memberDTO);

    mv.setViewName("pages/home");

    return mv;
  }

  @GetMapping("/member")
  public ModelAndView registerMove(ModelAndView mv, @ModelAttribute("member") MemberDTO memberDTO,
      @ModelAttribute("subsiName") String subsiName) {

    List<Subsidiary> subsiList = subsidiaryService.getAllList();

    mv.addObject("subsiList", subsiList);

    mv.setViewName("pages/register");

    return mv;

  }

  @GetMapping("/")
  public ModelAndView mainPage(ModelAndView mv) {

    mv.setViewName("pages/home");

    return mv;

  }

  @GetMapping("/home")
  public ModelAndView homePage(ModelAndView mv) {

    mv.setViewName("pages/home");

    return mv;

  }

  @Secured("MEMBER")
  @GetMapping("/user_info")
  public ModelAndView userInfoPage(ModelAndView mv) {

    mv.setViewName("pages/user_info");

    return mv;

  }

  @GetMapping("/subsiList")
  public ModelAndView subsiList(ModelAndView mv) {

    mv.setViewName("pages/login");

    return mv;

  }

}
