package com.zettamine.isa.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule implements IsaDto{
	private Integer scheduleId;
	private Integer applicantId;
	private Integer interviewerId;
	private Integer recruiterId;
	private String interviewDate;
	private String interviewTime;
	private String status;
}
