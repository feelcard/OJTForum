package com.kbds.kbforum.userstructure.display.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.kbds.kbforum.userstructure.displayauth.entity.DisplayAuth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * 파일명     : Display.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자	 	|			내	용		         |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	        유한솔             	|          화면 엔티티                          |	
 * ===============================================================================
 * </pre>
 */

@Entity(name = "DISPLAY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Display {

  @Id
  private String displayId;

  private String displayName;

  private String displayStatus;

  private String displayUrl;

  private String displayCreateBy;

  private String displayCreateDate;

  private String displayUpdateBy;

  private String displayUpdateDate;

  private String displayDelete;

  @OneToMany(mappedBy = "display", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<DisplayAuth> displayAuths = new HashSet<>();

}
