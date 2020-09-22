package com.kbds.kbforum.domain.file;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.kbds.kbforum.domain.forum.Forum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * 파일명     : File.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자	 	|			 내	용		         |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	       유한솔       	|          파일 엔티티                          |	
 * ===============================================================================
 * </pre>
 */

@Entity(name = "FILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

  @Id
  private String fileId;

  private String filePath;

  private String fileSize;

  private String fileCreateDate;

  private String fileType;

  @ManyToOne
  @JoinColumn(name = "forum_id")
  private Forum forum;

}
