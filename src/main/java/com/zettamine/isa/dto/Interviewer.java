package com.zettamine.isa.dto;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interviewer implements IsaDto {
	private Integer interviewerId;
	private String interviewerName;
	private String email;
	private String phoneNumber;
	private Integer primarySkill;
}
