package com.kbds.kbforum.userstructure.subsidiary.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.kbds.kbforum.userstructure.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <pre>
 * 파일명     : Subsidiary.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * =============================================================================
 * 			날짜	      		|    	작성자		|			내	용		       |	  
 * =============================================================================
 * 	     2020. 9. 17.       |	       유한솔       	|          계열사 엔티티                    |	
 * =============================================================================
 * </pre>
 */

@Entity(name = "SUBSIDIARY")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subsidiary {

  @Id
  private String subsiId;

  private String subsiName;

  private String subsiCreateDate;

  private String subsiUpdateBy;

  private String subsiUpdateDate;

  private String subsiDelete;

  @OneToMany(mappedBy = "subsi", fetch = FetchType.EAGER)
  Set<Member> members = new HashSet<Member>();

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((subsiCreateDate == null) ? 0 : subsiCreateDate.hashCode());
    result = prime * result + ((subsiDelete == null) ? 0 : subsiDelete.hashCode());
    result = prime * result + ((subsiId == null) ? 0 : subsiId.hashCode());
    result = prime * result + ((subsiName == null) ? 0 : subsiName.hashCode());
    result = prime * result + ((subsiUpdateBy == null) ? 0 : subsiUpdateBy.hashCode());
    result = prime * result + ((subsiUpdateDate == null) ? 0 : subsiUpdateDate.hashCode());
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
    Subsidiary other = (Subsidiary) obj;
    if (subsiCreateDate == null) {
      if (other.subsiCreateDate != null)
        return false;
    } else if (!subsiCreateDate.equals(other.subsiCreateDate))
      return false;
    if (subsiDelete == null) {
      if (other.subsiDelete != null)
        return false;
    } else if (!subsiDelete.equals(other.subsiDelete))
      return false;
    if (subsiId == null) {
      if (other.subsiId != null)
        return false;
    } else if (!subsiId.equals(other.subsiId))
      return false;
    if (subsiName == null) {
      if (other.subsiName != null)
        return false;
    } else if (!subsiName.equals(other.subsiName))
      return false;
    if (subsiUpdateBy == null) {
      if (other.subsiUpdateBy != null)
        return false;
    } else if (!subsiUpdateBy.equals(other.subsiUpdateBy))
      return false;
    if (subsiUpdateDate == null) {
      if (other.subsiUpdateDate != null)
        return false;
    } else if (!subsiUpdateDate.equals(other.subsiUpdateDate))
      return false;
    return true;
  }



}
