package com.kbds.kbforum.domain.reply.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.kbds.kbforum.domain.forum.entity.Forum;
import com.kbds.kbforum.userstructure.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * 파일명     : Reply.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ============================================================================
 * 			날짜	      		|    	작성자		|			내	용		      |	  
 * ============================================================================
 * 	     2020. 9. 17.       |	       유한솔       	|          답글 엔티티                    |	
 * ============================================================================
 * </pre>
 */

@Entity(name = "REPLY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

  @Id
  private String replyId;

  private String replyField;

  private String replyUpdateDate;

  private String replyUpdateBy;

  private String replyCreateDate;

  private String replyCreateBy;

  @ManyToOne
  @JoinColumn(name = "forum_id")
  private Forum forum;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "parent_reply_id")
  private Reply parent;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
  private Set<Reply> childReplys = new HashSet<Reply>();

}
