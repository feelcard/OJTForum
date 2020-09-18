package com.kbds.kbforum.domain.subsidiary;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.kbds.kbforum.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Subsidiary {

  @Id
  private String subsiId;

  private String subsiName;

  private String subsiCreateDate;

  private String subsiUpdateBy;

  private String subsiUpdateDate;

  private String subsiDelete;

  @OneToMany(mappedBy = "subsi", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  Set<Member> members = new HashSet<Member>();

}
