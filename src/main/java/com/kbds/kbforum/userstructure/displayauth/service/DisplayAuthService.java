package com.kbds.kbforum.userstructure.displayauth.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import com.kbds.kbforum.userstructure.displayauth.dto.DisplayAuthDTO;
import com.kbds.kbforum.userstructure.displayauth.entity.DisplayAuth;
import com.kbds.kbforum.userstructure.displayauth.mapper.DisplayAuthRepository;

@Service
public class DisplayAuthService {

  @Autowired
  DisplayAuthRepository displayAuthRepository;

  @Cacheable("DisplayAuthList")
  public List<DisplayAuthDTO> getAll() {

    List<DisplayAuthDTO> list = new ArrayList<DisplayAuthDTO>();

    for (DisplayAuth da : displayAuthRepository.findAll()) {

      list.add(new DisplayAuthDTO(da.getDisplayAuthId()));

    }

    return list;

  }

  @Caching(evict = {@CacheEvict(cacheNames = "DisplayAuthList", allEntries = true)})
  public void removeDisplayAuthCache() {}

}
