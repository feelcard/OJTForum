package com.kbds.kbforum.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kbds.kbforum.domain.authority.AuthorityService;
import com.kbds.kbforum.domain.member.Member;
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
  AuthorityService authorityService;


  @PostMapping("/register-processing")
  public ModelAndView registerProcessingMember(ModelAndView mv,
      @ModelAttribute("member") Member member, String subsiName) {
    member.setAuth(authorityService.getAuth("USER"));
    System.out.println("subsiname : " + subsiName);
    member.setSubsi(subsidiaryService.getSubsiByName(subsiName));
    memberService.save(member);
    System.out.println("member registered");
    mv.setViewName("pages/home");
    return mv;
  }

  @GetMapping("/signup")
  public ModelAndView registerMove(ModelAndView mv, @ModelAttribute("member") Member member,
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

  @GetMapping("/user_info")
  public ModelAndView userInfoPage(ModelAndView mv) {
    mv.setViewName("pages/user_info");
    return mv;
  }

  @GetMapping("/login")
  public ModelAndView loginProcessing(ModelAndView mv) {
    mv.setViewName("pages/login");
    return mv;
  }

  @GetMapping("/subsiList")
  public ModelAndView subsiList(ModelAndView mv) {

    mv.setViewName("pages/login");
    return mv;
  }

}
