package com.kbds.kbforum.domain.forum.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kbds.kbforum.domain.forum.entity.Forum;

/**
 * <pre>
 * 파일명     : ForumRepository.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * =============================================================================================
 * 			날짜	       |      작성자		|		            	내	용		            |	  
 * =============================================================================================
 * 	     2020. 9. 17.      |	  유한솔       	|  게시판 엔티티를 DB에서 접근하기 위한 Repo    |	
 * =============================================================================================
 * </pre>
 */

public interface ForumRepository extends JpaRepository<Forum, String> {

}
