package com.kbds.kbforum.domain.authority;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.kbds.kbforum.domain.displayauth.DisplayAuth;
import com.kbds.kbforum.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
