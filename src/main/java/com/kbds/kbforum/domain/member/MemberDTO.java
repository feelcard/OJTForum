package com.kbds.kbforum.domain.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.kbds.kbforum.domain.authority.Authority;
import com.kbds.kbforum.domain.subsidiary.Subsidiary;

public class MemberDTO implements UserDetails {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  private String memberId;

  private String memberPassword;

  private String memberName;

  private Authority auth;

  private Subsidiary subsi;


  public MemberDTO() {
    super();
  }

  public MemberDTO(String memberId, String memberPassword, String memberName, Subsidiary subsi) {
    super();
    this.memberId = memberId;
    this.memberPassword = memberPassword;
    this.memberName = memberName;
    this.subsi = subsi;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    List<GrantedAuthority> authlist = new ArrayList<GrantedAuthority>();

    authlist.add(new SimpleGrantedAuthority("MEMBER"));

    return authlist;

  }

  @Override
  public String getPassword() {

    return memberPassword;

  }

  @Override
  public String getUsername() {

    return memberId;

  }

  @Override
  public boolean isAccountNonExpired() {

    return true;

  }

  @Override
  public boolean isAccountNonLocked() {

    return true;

  }

  @Override
  public boolean isCredentialsNonExpired() {

    return true;

  }

  @Override
  public boolean isEnabled() {

    return true;

  }

  public Subsidiary getSubsi() {

    return subsi;

  }

  public void setSubsi(Subsidiary subsi) {

    this.subsi = subsi;

  }

  public String getMemberName() {

    return memberName;

  }

  public void setMemberName(String memberName) {

    this.memberName = memberName;

  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getMemberPassword() {
    return memberPassword;
  }

  public void setMemberPassword(String memberPassword) {
    this.memberPassword = memberPassword;
  }

  public Authority getAuth() {
    return auth;
  }

  public void setAuth(Authority auth) {
    this.auth = auth;
  }

}
