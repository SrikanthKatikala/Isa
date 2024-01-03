package com.zettamine.isa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewSchedule implements IsaDto {
	
	private Integer scheduleId;
	private String applicantName;
	private String interviewerName;
	private String recruiterName;
	private String interviewDate;
	private String interviewTime;
	private String status;
}
