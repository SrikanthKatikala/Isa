package com.zettamine.isa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteriaImpl implements SearchCriteria {

	private Integer recruiterId;
	private String userName;
    private String userPassword;
	private String email;
	
	private Integer skillId;
	private String skillDcse;
	private Integer applicantId;
	private Integer interviewerId;
	
}
