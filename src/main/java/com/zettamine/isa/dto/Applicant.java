package com.zettamine.isa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applicant implements IsaDto{
	
	private Integer applicantId;
	private String applicantName;
	private String email;
	private String phoneNumber;
	private String highestQualification;
	private String applicantRemarks;
	private Integer primarySkill;
}
