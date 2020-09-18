package com.kbds.kbforum.domain.subsidiary;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * <pre>
 * 파일명     : SubsidiaryService.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		|			내	용		         |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	       유한솔       	|       계열사 Read 기능 구현                |	
 * ===============================================================================
 * </pre>
 */
@Service
public class SubsidiaryService {

  @Autowired
  SubsidiaryRepository subsidiaryRepository;

  public List<Subsidiary> getAllList() {

    return subsidiaryRepository.findAll();

  }

  public Subsidiary getSubsiByName(String subsiName) {

    return subsidiaryRepository.findBySubsiName(subsiName);

  }

}
