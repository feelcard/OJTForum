package com.kbds.kbforum.domain.displayauth;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.kbds.kbforum.domain.authority.Authority;
import com.kbds.kbforum.domain.display.Display;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * <pre>
 * 파일명     : DisplayAuth.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자	 	|		    	내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	       유한솔       	|   권한에 따른 화면구성을 위한 엔티티         |	
 * ===============================================================================
 * </pre>
 */
@Entity(name = "DISPLAY_AUTH")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DisplayAuth {
  @Id
  private String displayAuthId;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "display_id")
  private Display display;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "auth_code")
  private Authority auth;
}
