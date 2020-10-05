package com.kbds.kbforum.core.config.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import com.kbds.kbforum.userstructure.displayauth.dto.DisplayAuthDTO;
import com.kbds.kbforum.userstructure.displayauth.entity.DisplayAuth;
import com.kbds.kbforum.userstructure.displayauth.mapper.DisplayAuthRepository;
import com.kbds.kbforum.userstructure.displayauth.service.DisplayAuthService;
import com.kbds.kbforum.userstructure.member.dto.MemberDTO;
import com.kbds.kbforum.userstructure.member.entity.Member;
import com.kbds.kbforum.userstructure.member.mapper.MemberRepository;

@Component
public class AuthorizationChecker {
  @Autowired
  private DisplayAuthService displayAuthService;

  @Autowired
  private DisplayAuthRepository displayAuthRepository;

  @Autowired
  private MemberRepository memberRepository;

  public boolean check(HttpServletRequest request, Authentication authentication) {
    Object principalObj = authentication.getPrincipal();
    System.out.println("principalObj : " + principalObj.toString());
    if (!(principalObj instanceof MemberDTO)) {
      System.out.println("instanceof check false");
      return false;
    }

    String authority = null;
    for (DisplayAuthDTO matcher : displayAuthService.getAll()) {
      DisplayAuth displayAuth = displayAuthRepository.findOne(matcher.getDisplayAuthId());
      if (new AntPathMatcher().match(displayAuth.getDisplay().getDisplayUrl(),
          request.getRequestURI())) {
        System.out.println("matcher :" + matcher);
        System.out.println("matcher URL :" + displayAuth.getDisplay().getDisplayUrl());
        System.out.println("Request URI :" + request.getRequestURI());
        authority = displayAuth.getAuth().getAuthCode();
        break;
      }

    }

    String userId = ((MemberDTO) authentication.getPrincipal()).getMemberId();
    Member loggedUser = memberRepository.findByMemberId(userId).get();
    String authorities = loggedUser.getAuth().getAuthCode();

    if (authority == null || !authorities.contains(authority)) {
      System.out.println("authority :" + authority);
      System.out.println("authorities : " + authorities);
      System.out.println("authority check false");
      return false;
    }
    return true;
  }
}
