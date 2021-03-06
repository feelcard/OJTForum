package com.kbds.kbforum.core.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.kbds.kbforum.userstructure.authority.mapper.AuthorityRepository;
import com.kbds.kbforum.userstructure.display.mapper.DisplayRepository;
import com.kbds.kbforum.userstructure.displayauth.mapper.DisplayAuthRepository;

/**
 * <pre>
 * 파일명     : SecurityConfig.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * =========================================================================
 * 		    	날짜	  		|    	작성자		 	|		        	내	용	   	       |	  
 * =========================================================================
 * 	   2020. 9. 17.    |	    유한솔     	|   SpringSecurity 설정 클래스   |	
 * =========================================================================
 * </pre>
 */

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
// @Secured 와 @PreAuthent 를 사용하려면 해당 변수들을 true로 선언해야함
@ComponentScan("com.kbds.kbforum.*") // 한번만 스캔할 수 있는 방법이 있을까?
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  CustomAuthenticationProvider customAuthenticationProvider;

  @Autowired
  CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

  @Autowired
  AuthorityRepository authorityRepository;

  @Autowired
  DisplayRepository displayRepository;

  @Autowired
  DisplayAuthRepository displayAuthRepository;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    auth.authenticationProvider(customAuthenticationProvider);
    // auth.userDetailsService(memberService).passwordEncoder(passwordEncoder()); (해당 문장은
    // DaoAuthenticationProvider 사용)


  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // ================login================
    // List<DisplayAuth> displayAuthList = displayAuthRepository.findAll();
    // // 등록된 권한 및 화면 목록을 가져와서 등록한다.
    // if (displayAuthList != null)
    // for (DisplayAuth displayAuth : displayAuthList) {
    //
    // http.authorizeRequests().antMatchers(displayAuth.getDisplay().getDisplayUrl())
    // .hasRole(displayAuth.getAuth().getAuthCode());
    //
    // }

    http.authorizeRequests()

        .antMatchers("/admin/**").hasRole("ADMIN")

        .antMatchers("/member", "/").permitAll()// .anonymous()

        .anyRequest().access("@authorizationChecker.check(request, authentication)")

        .and()

        .formLogin()

        .loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/")

        .usernameParameter("id").passwordParameter("password")

        .failureHandler(customAuthenticationFailureHandler).permitAll()

        .and()

        .exceptionHandling().accessDeniedPage("/login/error?message=권한이 없습니다. 관리자에게 문의하십시오")

        .and()

        .httpBasic();

    // =================logout===============
    http.logout().invalidateHttpSession(true);

  }

  /*
   * httpBasic() : http 통신으로 인증받겠다 (ssl로도 가능) authorizeRequests() : 접근권한이 허용된 요청만 처리하겠다는 의미
   * antMatchers() : String 경로 아래의 요청은 뒤의 설정할 조건에 맞는 계정이 인증되어야지만 접근 가능하다는 것.(/ == web) access() :
   * 주어진 SpEL 표현식의 평가 결과가 true이면 접근을 허용 (spEL= 스프링 표현언어) =>기본적으로 hasRole만 사용해서 globalconfig 에 설정한 것과
   * 일치하는 기준으로 엑세스를 설정할수 있지만 여러 경우가 존재했을때 hasRole 만으로는 부족하기 때문에 이와같은 형태를 이용해서 다양한 조건을 줄 수 있다.
   * formLogin() : form형태의 로그인 기능을 사용할 것이며 loginPage() 함수를 따로 지정하지 않을경우 "/login" 경로의 page가 스프링에서
   * 제공하는 default page 형태로 생성된다.
   * 
   * httpBasic() 메서드를 사용할 경우 유효한 사용자이름/암호 조합을 인코딩하는 base64와 같은 헤더를 전달하여 이를 테스트 할수있도록 한다.
   * 
   */

  @Bean
  public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();

  }

}
