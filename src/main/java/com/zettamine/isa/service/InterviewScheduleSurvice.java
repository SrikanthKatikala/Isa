package com.zettamine.isa.service;

import java.util.List;

import com.zettamine.isa.dao.InterviewScheduleDaoImpl;

import com.zettamine.isa.dto.InterviewSchedule;

public class InterviewScheduleSurvice {

	public List<InterviewSchedule> getAll() {
		InterviewScheduleDaoImpl dao = new InterviewScheduleDaoImpl();
		List<InterviewSchedule> all = dao.getAll();
		System.out.println(all);
		return all;
	}
}
