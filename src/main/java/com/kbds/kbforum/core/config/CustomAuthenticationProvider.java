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

  /*
   * 원래는 supports 함수는 AuthenticationManager의 요청에서 이 AuthenticationProvider가 인증 가능한지 체크하는 함수이다. 이를
   * 체크하는 이유는 인증 방식은 다양한 것이있고(id,pw기반 form,OAuth,JWT 등) 이 마다 각자의 AuthenticationProvider가 존재해야 한다.
   * 때문에 인증 객체도 모두 달라서 AuthenticationManager에서 각각의 커스텀한 AuthenticationProvider를 순회하여 supports를 호출해서
   * 해당 인증 객체를 처리할수 있는 AuthenticationProvider를 찾아서 인증 객체를 전달한다.
   */

}
