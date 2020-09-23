package com.kbds.kbforum.domain.forum.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainResource {

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

}
