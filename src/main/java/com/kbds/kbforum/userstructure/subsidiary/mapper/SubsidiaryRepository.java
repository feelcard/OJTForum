package com.kbds.kbforum.userstructure.subsidiary.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kbds.kbforum.userstructure.subsidiary.entity.Subsidiary;

/**
 * <pre>
 * 파일명     : SubsidiaryRepository.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ============================================================================================
 * 			날짜	      		|         작성자	       	 	|		          	내	용		                 |	  
 * ============================================================================================
 * 	     2020. 9. 17.  	|	        유한솔       	    | 계열사 엔티티를 DB에서 접근하기 위한 Repo |	
 * ============================================================================================
 * </pre>
 */

public interface SubsidiaryRepository extends JpaRepository<Subsidiary, String> {

  Subsidiary findBySubsiName(String subsiName);

}
