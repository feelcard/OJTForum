package com.kbds.kbforum.domain.authority.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kbds.kbforum.domain.authority.entity.Authority;
import com.kbds.kbforum.domain.authority.mapper.AuthorityRepository;

@Service
public class AuthorityService {

  @Autowired
  AuthorityRepository authorityRepository;

  public Authority getAuth(String authCode) {

    return authorityRepository.findByAuthCode(authCode);

  }

}
