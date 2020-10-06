package com.kbds.kbforum.core.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.kbds.kbforum.userstructure.member.service.MemberService;

/**
 * <pre>
 * 파일명     : CustomAuthenticationProvider.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 22.
 * ======================================================================
 * 			날짜	      		|    	작성자		 	|		      	내	용		        |	  
 * ======================================================================
 * 	     2020. 9. 22.   |	    유한솔    	|     계정 인증 및 인가       |	
 * ======================================================================
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
    if (authentication == null) {
      throw new InternalAuthenticationServiceException("Authentication is null");
    }
    String username = authentication.getName();
    if (authentication.getCredentials() == null) {
      throw new AuthenticationCredentialsNotFoundException("Credentials is null");
    }
    String password = authentication.getCredentials().toString();
    UserDetails loadedUser = memberService.loadUserByUsername(username);
    if (loadedUser == null) {
      throw new InternalAuthenticationServiceException("입력한 정보에 해당하는 계정이 없습니다. 계정을 확인해 주십시오.");
    }

    // /* checker */ if (!loadedUser.isAccountNonLocked()) {
    // throw new LockedException("User account is locked");
    // }
    // if (!loadedUser.isEnabled()) {
    // throw new DisabledException("User is disabled");
    // }
    // if (!loadedUser.isAccountNonExpired()) {
    // throw new AccountExpiredException("User account has expired");
    // }

    /* 실질적인 인증 */ if (!passwordEncoder.matches(password, loadedUser.getPassword())) {
      throw new BadCredentialsException("암호가 일치하지 않습니다. 다시확인해 주십시오.");
    }

    // /* checker */ if (!loadedUser.isCredentialsNonExpired()) {
    // throw new CredentialsExpiredException("User credentials have expired");
    // }

    /* 인증 완료 */ UsernamePasswordAuthenticationToken result =
        new UsernamePasswordAuthenticationToken(loadedUser, null, loadedUser.getAuthorities());
    result.setDetails(authentication.getDetails());
    return result;
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
