package com.kbds.kbforum.domain.display;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * <pre>
 * 파일명     : DisplayService.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	       유한솔               	|    화면Create,Read 구현             |	
 * ===============================================================================
 * </pre>
 */
@Service
public class DisplayService {

  @Autowired
  DisplayRepository displayRepository;

  public void add(Display display) {
    // System.out.println(" displayserviceimpl display insert : " + display.toString());
    displayRepository.save(display);

  }

  public List<Display> listDisplays() {
    return displayRepository.findAll();
  }

}
