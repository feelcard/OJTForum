package com.kbds.kbforum.domain.member.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kbds.kbforum.domain.authority.service.AuthorityService;
import com.kbds.kbforum.domain.member.dto.MemberDTO;
import com.kbds.kbforum.domain.member.service.MemberService;
import com.kbds.kbforum.domain.subsidiary.entity.Subsidiary;
import com.kbds.kbforum.domain.subsidiary.service.SubsidiaryService;

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
@RequestMapping("/member")
public class MemberResource {

  @Autowired
  MemberService memberService;
  @Autowired
  SubsidiaryService subsidiaryService;
  @Autowired
  AuthorityService authorityService;


  @PostMapping
  public ModelAndView registerProcessingMember(ModelAndView mv,
      @ModelAttribute("member") MemberDTO memberDTO, String subsiName) {

    System.out.println(memberDTO);

    memberDTO.setSubsi(subsidiaryService.getSubsiByName(subsiName));

    memberService.save(memberDTO);

    mv.setViewName("pages/home");

    return mv;
  }

  @GetMapping
  public ModelAndView registerMove(ModelAndView mv, @ModelAttribute("member") MemberDTO memberDTO,
      @ModelAttribute("subsiName") String subsiName) {

    List<Subsidiary> subsiList = subsidiaryService.getAllList();

    mv.addObject("subsiList", subsiList);

    mv.setViewName("pages/register");

    return mv;

  }

  // @Secured("ROLE_MEMBER")
  @GetMapping("/user_info")
  public ModelAndView userInfoPage(ModelAndView mv) {

    mv.setViewName("pages/member/user_info");

    return mv;

  }


}
