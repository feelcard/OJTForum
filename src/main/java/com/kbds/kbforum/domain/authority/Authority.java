package com.kbds.kbforum.domain.authority;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.kbds.kbforum.domain.displayauth.DisplayAuth;
import com.kbds.kbforum.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <pre>
 * 파일명     : Authority.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.  	    |	       유한솔                   	|          권한 엔티티                     |	
 * ===============================================================================
 * </pre>
 */

@Entity(name = "authority")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"members", "displayAuths"})
public class Authority {

  @Id
  private String authCode;

  private String authName;

  private String authCreateBy;

  private String authCreateDate;

  private String authUpdateBy;

  private String authUpdateDate;

  private String authDelete;

  @OneToMany(mappedBy = "auth")
  Set<DisplayAuth> displayAuths = new HashSet<>();

  @OneToMany(mappedBy = "auth")
  Set<Member> members = new HashSet<>();

  @Override
  public int hashCode() {

    final int prime = 31;

    int result = 1;

    result = prime * result + ((authCode == null) ? 0 : authCode.hashCode());

    result = prime * result + ((authCreateBy == null) ? 0 : authCreateBy.hashCode());

    result = prime * result + ((authCreateDate == null) ? 0 : authCreateDate.hashCode());

    result = prime * result + ((authDelete == null) ? 0 : authDelete.hashCode());

    result = prime * result + ((authName == null) ? 0 : authName.hashCode());

    result = prime * result + ((authUpdateBy == null) ? 0 : authUpdateBy.hashCode());

    result = prime * result + ((authUpdateDate == null) ? 0 : authUpdateDate.hashCode());

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

    Authority other = (Authority) obj;

    if (authCode == null) {

      if (other.authCode != null)

        return false;

    } else if (!authCode.equals(other.authCode))

      return false;

    if (authCreateBy == null) {

      if (other.authCreateBy != null)

        return false;

    } else if (!authCreateBy.equals(other.authCreateBy))

      return false;

    if (authCreateDate == null) {

      if (other.authCreateDate != null)

        return false;

    } else if (!authCreateDate.equals(other.authCreateDate))

      return false;

    if (authDelete == null) {

      if (other.authDelete != null)

        return false;

    } else if (!authDelete.equals(other.authDelete))

      return false;

    if (authName == null) {

      if (other.authName != null)

        return false;

    } else if (!authName.equals(other.authName))

      return false;

    if (authUpdateBy == null) {

      if (other.authUpdateBy != null)

        return false;

    } else if (!authUpdateBy.equals(other.authUpdateBy))

      return false;

    if (authUpdateDate == null) {

      if (other.authUpdateDate != null)

        return false;

    } else if (!authUpdateDate.equals(other.authUpdateDate))

      return false;

    return true;

  }

}
