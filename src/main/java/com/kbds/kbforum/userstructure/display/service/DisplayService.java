package com.kbds.kbforum.userstructure.display.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kbds.kbforum.userstructure.display.entity.Display;
import com.kbds.kbforum.userstructure.display.mapper.DisplayRepository;

/**
 * <pre>
 * 파일명     : DisplayService.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ====================================================================
 * 			날짜	      		|    	작성자		 	|		       	내	용		      |	  
 * ====================================================================
 * 	     2020. 9. 17.   |	    유한솔    	|    화면 서비스 클래스     |	
 * ====================================================================
 * </pre>
 */

@Service
public class DisplayService {

  @Autowired
  DisplayRepository displayRepository;

  public void add(Display display) {

    displayRepository.save(display);

  }

  public List<Display> listDisplays() {

    return displayRepository.findAll();

  }

}
