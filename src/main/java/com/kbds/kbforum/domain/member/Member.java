package com.kbds.kbforum.domain.member;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.kbds.kbforum.domain.authority.Authority;
import com.kbds.kbforum.domain.reply.Reply;
import com.kbds.kbforum.domain.subsidiary.Subsidiary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



/**
 * <pre>
 * 파일명     : Member.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.       |	        유한솔                   	|          멤버 엔티티                    |	
 * ===============================================================================
 * </pre>
 */
@Entity(name = "MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
  @Id
  @Column
  private String memberId;
  @Column
  private String memberPassword;
  @Column
  private String memberName;
  @Column
  private String memberCreateDate;
  @Column
  private String memberUpdateBy;
  @Column
  private String memberUpdateDate;
  @Column
  private String memberDelete;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "auth_code")
  private Authority auth;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "subsi_id")
  private Subsidiary subsi;

  @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
  private Set<Reply> replys = new HashSet<Reply>();
}
