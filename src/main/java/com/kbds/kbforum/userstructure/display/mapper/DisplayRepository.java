package com.kbds.kbforum.userstructure.display.mapper;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kbds.kbforum.userstructure.display.entity.Display;

/**
 * <pre>
 * 파일명     : DisplayRepository.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 		   	날짜	      	|    	작성자	 	|	          	  	내	용		             |	  
 * ===============================================================================
 *    2020. 9. 17.      |     유한솔    |   권한 엔티티를 DB에서 부르기위한 Repo  |  
 * ===============================================================================
 * </pre>
 */

public interface DisplayRepository extends JpaRepository<Display, String> {

  List<Display> findByDisplayId(String id);

  List<Display> findByDisplayUrl(String url);

}
