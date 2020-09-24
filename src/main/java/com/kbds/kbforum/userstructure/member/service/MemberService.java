package com.kbds.kbforum.userstructure.member.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.kbds.kbforum.userstructure.authority.mapper.AuthorityRepository;
import com.kbds.kbforum.userstructure.member.dto.MemberDTO;
import com.kbds.kbforum.userstructure.member.entity.Member;
import com.kbds.kbforum.userstructure.member.mapper.MemberRepository;

/**
 * <pre>
 * 파일명     : MemberService.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===================================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		          |	  
 * ===================================================================================
 * 	    2020. 9. 17.     	|	        유한솔               	|스프링 시큐리티 기반의 회원가입 로직 구현중   |	
 * ===================================================================================
 * </pre>
 */

@Service
public class MemberService implements UserDetailsService {

  @Autowired
  MemberRepository memberRepository;
  @Autowired
  AuthorityRepository authorityRepository;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<Member> memberEntityWrapper = memberRepository.findByMemberId(username);

    Member memberEntity = memberEntityWrapper.orElse(null);

    if (memberEntity == null)
      return null;

    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    if (memberEntity.getAuth().getAuthCode().equals("MEMBER")) {

      authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

    }

    else {

      authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

    }

    return new MemberDTO(memberEntity.getMemberId(), memberEntity.getMemberPassword(),
        memberEntity.getMemberName(), memberEntity.getSubsi(), authorities);

  }


  @Transactional
  public void save(MemberDTO memberDTO) {
    Member member = new Member();

    member.setMemberId(memberDTO.getUsername());

    member.setMemberCreateDate(LocalDateTime.now().toString());

    member.setMemberDelete("N");

    member.setMemberName(memberDTO.getMemberName());

    member.setSubsi(memberDTO.getSubsi());

    member.setAuth(authorityRepository.findByAuthCode("MEMBER"));

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();// 비밀번호 암호화

    member.setMemberPassword(passwordEncoder.encode(memberDTO.getPassword()));

    System.out.println(member.toString());

    memberRepository.save(member);

  }

  public boolean checkID(MemberDTO memberDTO) {

    return memberRepository.exists(memberDTO.getUsername());

  }

}
