package com.zettamine.isa.controller;

import java.io.IOException;

import com.zettamine.isa.dto.Schedule;
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.service.IsaService;
import com.zettamine.isa.service.ScheduleSurviceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/schedule1")
public class SchedulingController extends HttpServlet{

	public static IsaService<Schedule, SearchCriteriaImpl> isaService;
	public static Schedule schedule;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		isaService = new ScheduleSurviceImpl();
		schedule = new Schedule();
		Integer applicantId = Integer.parseInt(req.getParameter("applicantId"));
		Integer interviewerId = Integer.parseInt(req.getParameter("interviewerId"));
		Integer recruiterId = Integer.parseInt(req.getParameter("recruiterId"));
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String status = req.getParameter("status");
		schedule.setApplicantId(applicantId);
		schedule.setInterviewerId(interviewerId);
		schedule.setRecruiterId(recruiterId);
		schedule.setInterviewDate(date);
		schedule.setInterviewTime(time);
		schedule.setStatus(status);
		
		isaService.save(schedule);
		RequestDispatcher rd = req.getRequestDispatcher("scheduling.jsp");
		rd.forward(req, resp);
	}
}
