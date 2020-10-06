package com.kbds.kbforum.domain.file.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kbds.kbforum.domain.file.entity.FileHis;


/**
 * <pre>
 * 파일명     : FileHisRepository.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * =========================================================================================
 * 			날짜		|    	작성자		|		        	내	용		               |	  
 * =========================================================================================
 * 	     2020. 9. 17.   |	    유한솔  	| 파일 히스토리 엔티티를 DB에서 부르기위한 Repo |	
 * =========================================================================================
 * </pre>
 */

public interface FileHisRepository extends JpaRepository<FileHis, String> {

}
