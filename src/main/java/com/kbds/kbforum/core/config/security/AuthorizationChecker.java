package com.kbds.kbforum.core.config.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import com.kbds.kbforum.userstructure.displayauth.entity.DisplayAuth;
import com.kbds.kbforum.userstructure.displayauth.mapper.DisplayAuthRepository;
import com.kbds.kbforum.userstructure.member.entity.Member;
import com.kbds.kbforum.userstructure.member.mapper.MemberRepository;

@Component
public class AuthorizationChecker {
  @Autowired
  private DisplayAuthRepository displayAuthRepository;
  @Autowired
  private MemberRepository memberRepository;

  public boolean check(HttpServletRequest request, Authentication authentication) {
    Object principalObj = authentication.getPrincipal();
    System.out.println("principalObj : ");
    if (!(principalObj instanceof Member)) {
      return false;
    }

    String authority = null;
    for (DisplayAuth matcher : displayAuthRepository.findAll()) {
      if (new AntPathMatcher().match(((DisplayAuth) matcher).getDisplay().getDisplayUrl(),
          request.getRequestURI())) {
        authority = matcher.getAuth().getAuthCode();
        break;
      }
    }

    String userId = ((Member) authentication.getPrincipal()).getMemberId();
    Member loggedUser = memberRepository.findByMemberId(userId).get();

    String authorities = loggedUser.getAuth().getAuthCode();

    if (authority == null || !authorities.contains(authority)) {
      return false;
    }
    return true;
  }
}
