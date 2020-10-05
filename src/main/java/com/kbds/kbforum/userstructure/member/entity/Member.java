package com.kbds.kbforum.userstructure.member.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.kbds.kbforum.domain.reply.entity.Reply;
import com.kbds.kbforum.userstructure.authority.entity.Authority;
import com.kbds.kbforum.userstructure.subsidiary.entity.Subsidiary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <pre>
 * 파일명     : Member.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	        유한솔                   	|          멤버 엔티티                    |	
 * ===============================================================================
 * </pre>
 */

@Entity(name = "MEMBER")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "replys")
public class Member {

  @Id
  private String memberId;

  private String memberPassword;

  private String memberName;

  private String memberCreateDate;

  private String memberUpdateBy;

  private String memberUpdateDate;

  private String memberDelete;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "auth_code")
  private Authority auth;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "subsi_id")
  private Subsidiary subsi;

  @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
  private Set<Reply> replys = new HashSet<Reply>();

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((auth == null) ? 0 : auth.hashCode());
    result = prime * result + ((memberCreateDate == null) ? 0 : memberCreateDate.hashCode());
    result = prime * result + ((memberDelete == null) ? 0 : memberDelete.hashCode());
    result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
    result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
    result = prime * result + ((memberPassword == null) ? 0 : memberPassword.hashCode());
    result = prime * result + ((memberUpdateBy == null) ? 0 : memberUpdateBy.hashCode());
    result = prime * result + ((memberUpdateDate == null) ? 0 : memberUpdateDate.hashCode());
    result = prime * result + ((subsi == null) ? 0 : subsi.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member other = (Member) obj;
    if (auth == null) {
      if (other.auth != null)
        return false;
    } else if (!auth.equals(other.auth))
      return false;
    if (memberCreateDate == null) {
      if (other.memberCreateDate != null)
        return false;
    } else if (!memberCreateDate.equals(other.memberCreateDate))
      return false;
    if (memberDelete == null) {
      if (other.memberDelete != null)
        return false;
    } else if (!memberDelete.equals(other.memberDelete))
      return false;
    if (memberId == null) {
      if (other.memberId != null)
        return false;
    } else if (!memberId.equals(other.memberId))
      return false;
    if (memberName == null) {
      if (other.memberName != null)
        return false;
    } else if (!memberName.equals(other.memberName))
      return false;
    if (memberPassword == null) {
      if (other.memberPassword != null)
        return false;
    } else if (!memberPassword.equals(other.memberPassword))
      return false;
    if (memberUpdateBy == null) {
      if (other.memberUpdateBy != null)
        return false;
    } else if (!memberUpdateBy.equals(other.memberUpdateBy))
      return false;
    if (memberUpdateDate == null) {
      if (other.memberUpdateDate != null)
        return false;
    } else if (!memberUpdateDate.equals(other.memberUpdateDate))
      return false;
    if (subsi == null) {
      if (other.subsi != null)
        return false;
    } else if (!subsi.equals(other.subsi))
      return false;
    return true;
  }



}
