package com.kbds.kbforum.domain.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

  @Autowired
  AuthorityRepository authorityRepository;

  public Authority getAuth(String authCode) {
    return authorityRepository.findByAuthCode(authCode);
  };
}
