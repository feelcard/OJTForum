package com.kbds.kbforum.domain.forum;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.kbds.kbforum.domain.file.File;
import com.kbds.kbforum.domain.member.Member;
import com.kbds.kbforum.domain.reply.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <pre>
 * 파일명     : Forum.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 *          날짜                        |       작성자          |            내  용                                 |    
 * ===============================================================================
 *       2020. 9. 17.       |       유한솔          |          게시판 엔티티                           |    
 * ===============================================================================
 * </pre>
 */



@Entity(name = "FOURM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Forum {
  @Id
  private String forumId;
  private String forumField;
  private String forumTitle;
  private String forumCreateDate;
  private String forumCreateBy;
  private String forumUpdateDate;
  private String forumUpdateBy;

  @ManyToOne
  @JoinColumn(name = "member_id")
  // ���� �������� �ٸ������ 1�� (�� ��ü�� �ҷ��ö� ���������)
  private Member member;



  @OneToMany(mappedBy = "forum", fetch = FetchType.EAGER)
  private Set<File> files = new HashSet<File>();

  @OneToMany(mappedBy = "forum", fetch = FetchType.EAGER)
  private Set<Reply> replys = new HashSet<Reply>();



  // void foo(){
  // member.getSubsi().getSubsiId();
  // }
  // }
}