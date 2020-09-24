package com.kbds.kbforum.userstructure.member.dto;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.kbds.kbforum.userstructure.subsidiary.entity.Subsidiary;

public class MemberDTO implements UserDetails {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  private String memberId;

  private String memberPassword;

  private String memberName;

  private List<GrantedAuthority> grantedAuthorityList;

  private Subsidiary subsi;


  public MemberDTO() {
    super();
  }

  public MemberDTO(String memberId, String memberPassword, String memberName, Subsidiary subsi,
      List<GrantedAuthority> grantedAuthorityList) {
    super();
    this.memberId = memberId;
    this.memberPassword = memberPassword;
    this.memberName = memberName;
    this.subsi = subsi;
    this.grantedAuthorityList = grantedAuthorityList;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    return this.grantedAuthorityList;

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

  public List<GrantedAuthority> getGrantedAuthorityList() {
    return grantedAuthorityList;
  }

  public void setGrantedAuthorityList(List<GrantedAuthority> grantedAuthorityList) {
    this.grantedAuthorityList = grantedAuthorityList;
  }

}
