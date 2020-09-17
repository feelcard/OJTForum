package com.kbds.kbforum.domain.reply;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * 파일명     : ReplyRepository.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		|			내	용		         |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	       유한솔       	| 답글 엔티티를 DB에서 접근하기 위한 Repo |	
 * ===============================================================================
 * </pre>
 */

public interface ReplyRepository extends JpaRepository<Reply, String> {

}
