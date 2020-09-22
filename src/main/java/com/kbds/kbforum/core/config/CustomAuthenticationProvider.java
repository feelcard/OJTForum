package com.kbds.kbforum.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.kbds.kbforum.domain.member.MemberDTO;
import com.kbds.kbforum.domain.member.MemberService;

/**
 * <pre>
 * 파일명     : CustomAuthenticationProvider.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 22.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 22.     	|	       유한솔                	|       계정 인증 및 인가                   |	
 * ===============================================================================
 * </pre>
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  MemberService memberService;
  @Autowired
  PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    MemberDTO member =
        (MemberDTO) memberService.loadUserByUsername(authentication.getPrincipal().toString());
    String username = authentication.getName();// 아이디
    String pwd = (String) authentication.getCredentials();
    Object obj = authentication.getPrincipal();
    System.out.println(username + "," + pwd + "," + obj);

    boolean state = passwordEncoder.matches(pwd, member.getMemberPassword());
    UsernamePasswordAuthenticationToken authUser = null;
    System.out.println("member.getAuthorities() :" + member.getAuthorities());
    authUser = new UsernamePasswordAuthenticationToken(member, pwd, member.getAuthorities());
    System.out.println(state);
    return authUser;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    // TODO Auto-generated method stub
    return true;

  }

}
