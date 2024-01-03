package com.zettamine.isa.controller;

import java.io.IOException;

import com.zettamine.isa.dto.InterviewSchedule;
import com.zettamine.isa.service.InterviewScheduleSurvice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/schedule1")
public class InterviewScheduleController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	   
	private static InterviewScheduleSurvice service = new InterviewScheduleSurvice();
	private static InterviewSchedule schedule = new InterviewSchedule();
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//	 String forward="";	 
//	 String action = request.getParameter("action");	 
//	 if(action==null)
//	 {
//	  // forward = "/scheduleUpdate.jsp";
//	   request.setAttribute("sched", service.getAll());
//	 }
	 
//	 else if(action.equalsIgnoreCase("edit"))
//	 {
//	  forward = "/scheduleView.jsp";
//	  Integer id = Integer.parseInt(request.getParameter("scheduleId"));
////	  List<Interviewer> list = isaService.getBySearchCriteria(criteria);
////	  
////	  request.setAttribute("all", list);
//	  request.setAttribute("label","Update User");
//	  request.setAttribute("hlabel", "Edit User");
//	 }  
	 
//	 else if(action.equalsIgnoreCase("delete"))
//	 { 
//		 schedule = new InterviewSchedule();
//		 Integer id = Integer.parseInt(request.getParameter("scheduleId"));
//		 schedule.setScheduleId(id);
//		 isaService.delete(schedule);
//		 forward ="/scheduleUpdate.jsp";
//		 request.setAttribute("sched", isaService.getAll());
//	 }
	 request.setAttribute("sched", service.getAll());
	 System.out.println(service.getAll());
	 RequestDispatcher view = request.getRequestDispatcher("scheduleUpdate.jsp");
	 view.forward(request, response);	
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
//
//		schedule = new Schedule();
//		schedule.setApplicantId(request.getParameter("name"));
//		schedule.setEmail(request.getParameter("email"));
//		schedule.setPhoneNumber(request.getParameter("mobile"));
//		int int1 = Integer.parseInt(request.getParameter("skill"));
//		interviewer.setPrimarySkill(int1);
//
//	 String interviewerId = request.getParameter("interviewerId");
//	 if(interviewerId == null || interviewerId.isEmpty())
//	 {
//		isaService.save(interviewer);
//	 }
//	 else
//	 {
//		interviewer.setInterviewerId(Integer.parseInt(interviewerId));
//		isaService.update(interviewer, interviewerId);
//	 }
//	 RequestDispatcher view = request.getRequestDispatcher("/interviewerView.jsp");
//	 request.setAttribute("intrvr", isaService.getAll());
//	 view.forward(request, response);
	}
}
