package com.kbds.kbforum.domain.forum;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <pre>
 * 파일명     : ForumHis.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 *          날짜                        |       작성자          |            내  용                                 |    
 * ===============================================================================
 *       2020. 9. 17.       |       유한솔          |          게시판 엔티티                           |    
 * ===============================================================================
 * </pre>
 */


@Entity(name = "FOURM_HIS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ForumHis {
  @Id
  private String forumHisId;
  private String forumId;
  private String forumField;
  private String forumTitle;
  private String forumCreateDate;
  private String forumCreateBy;
  private String forumDeleteDate;
  private String forumDeleteBy;
  private String memberId;
  private String subsiId;
  private String auth_code;// ������ ����� �����ڵ�
}
