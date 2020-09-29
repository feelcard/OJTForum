package com.kbds.kbforum.userstructure.member.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kbds.kbforum.userstructure.authority.service.AuthorityService;
import com.kbds.kbforum.userstructure.member.dto.MemberDTO;
import com.kbds.kbforum.userstructure.member.service.MemberService;
import com.kbds.kbforum.userstructure.subsidiary.dto.SubsidiaryDTO;
import com.kbds.kbforum.userstructure.subsidiary.service.SubsidiaryService;

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

  @GetMapping
  public ModelAndView registerMove(ModelAndView mv, @ModelAttribute("member") MemberDTO memberDTO,
      @ModelAttribute("subsiName") String subsiName) {

    List<SubsidiaryDTO> subsiList = subsidiaryService.getAllList();

    mv.addObject("subsiList", subsiList);

    mv.setViewName("pages/register");

    return mv;

  }


  @PostMapping
  public ModelAndView registerProcessingMember(ModelAndView mv,
      @ModelAttribute("member") MemberDTO memberDTO, String subsiName) {

    System.out.println(memberDTO);

    memberDTO.setSubsi(subsidiaryService.getSubsiByName(subsiName));

    memberService.save(memberDTO);

    mv.setViewName("pages/home");

    return mv;
  }

  @GetMapping("/info")
  public ModelAndView userInfoPage(ModelAndView mv) {

    mv.setViewName("pages/member/member_info");

    return mv;

  }


}
