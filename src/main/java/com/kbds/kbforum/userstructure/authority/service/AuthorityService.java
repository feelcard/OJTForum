package com.kbds.kbforum.userstructure.authority.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kbds.kbforum.userstructure.authority.entity.Authority;
import com.kbds.kbforum.userstructure.authority.mapper.AuthorityRepository;

/**
 * <pre>
 * 파일명     : AuthorityService.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 10. 5.
 * ====================================================================
 * 		   	날짜	      		|    	작성자		 	|		     	내	용		      |	  
 * ====================================================================
 * 	   2020. 10. 5.       |	    유한솔     	|   권한 서비스 클래스    |	
 * ====================================================================
 * </pre>
 */

@Service
public class AuthorityService {

  @Autowired
  AuthorityRepository authorityRepository;

  public Authority getAuth(String authCode) {

    return authorityRepository.findByAuthCode(authCode);

  }

}
