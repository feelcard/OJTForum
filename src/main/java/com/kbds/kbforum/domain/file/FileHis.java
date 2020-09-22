package com.kbds.kbforum.domain.file;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * 파일명     : FileHis.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===========================================================================
 * 			날짜	      		|    	작성자       	|		  	내	용	  	     |	  
 * ===========================================================================
 * 	     2020. 9. 17.       |	         유한솔         	|       파일 히스토리 엔티티            |	
 * ===========================================================================
 * </pre>
 */

@Entity(name = "FILE_HIS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileHis {

  @Id
  private String fileHisId;

  private String fileId;

  private String forumId;

  private String filePath;

  private String fileSize;

  private String fileCreateBy;

  private String fileCreateDate;

  private String fileType;

  private String fileDeleteBy;

  private String fileDeleteDate;
}
