package com.kbds.kbforum.userstructure.subsidiary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import com.kbds.kbforum.userstructure.subsidiary.entity.Subsidiary;
import com.kbds.kbforum.userstructure.subsidiary.mapper.SubsidiaryRepository;



/**
 * <pre>
 * 파일명     : SubsidiaryService.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		|			내	용		         |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	       유한솔       	    |       계열사 Read 기능 구현                |	
 * ===============================================================================
 * </pre>
 */
@Service
public class SubsidiaryService {

  @Autowired
  SubsidiaryRepository subsidiaryRepository;

  @Cacheable(cacheNames = "subsidiaryList")
  public List<Subsidiary> getAllList() {

    return subsidiaryRepository.findAll();

  }

  @Caching(evict = {@CacheEvict(cacheNames = "subsidiaryList", allEntries = true)})
  public void removeCacheUsers() {}

  public Subsidiary getSubsiByName(String subsiName) {

    return subsidiaryRepository.findBySubsiName(subsiName);

  }

}
