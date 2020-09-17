package com.kbds.kbforum.domain.authority;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 * <pre>
 * 파일명     : AuthorityRepository.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	       유한솔                  	|권한 엔티티를 DB에서 부르기위한 Repo |	
 * ===============================================================================
 * </pre>
 */


public interface AuthorityRepository extends JpaRepository<Authority, String> {

}
