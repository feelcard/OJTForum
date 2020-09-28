package com.kbds.kbforum.domain.forum.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.kbds.kbforum.userstructure.subsidiary.service.SubsidiaryService;

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
