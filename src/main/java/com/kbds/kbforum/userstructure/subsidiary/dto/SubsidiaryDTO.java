package com.kbds.kbforum.userstructure.subsidiary.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubsidiaryDTO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String subsiId;

  private String subsiName;



}
