package com.kbds.kbforum.domain.member.mapper;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.kbds.kbforum.domain.member.entity.Member;


/**
 * <pre>
 * 파일명     : MemberRepository.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자       	|		   	내	용		         |	  
 * ===============================================================================
 * 	     2020. 9. 17.  	    |	        유한솔         	|  멤버 엔티티를 DB에서 접근하기위한 Repo |	
 * ===============================================================================
 * </pre>
 */
public interface MemberRepository extends JpaRepository<Member, String> {

  Member findByMemberName(String memberName);

  Optional<Member> findByMemberId(String memberId);

}
