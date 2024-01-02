package com.zettamine.isa.controller;

import java.io.IOException;

import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.dto.Schedule;
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.service.InterviewerService;
import com.zettamine.isa.service.IsaService;
import com.zettamine.isa.service.ScheduleSurviceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/schedule1")
public class InterviewScheduleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	   
	private static IsaService<Schedule, SearchCriteriaImpl> isaService;
	private static Schedule schedule;
	@Override
	public void init(ServletConfig config) throws ServletException {
		isaService = new ScheduleSurviceImpl();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 String forward="";	 
	 String action = request.getParameter("action");	 
	 if(action==null)
	 {
	   forward = "/scheduleUpdate.jsp";
	   request.setAttribute("sched", isaService.getAll());
	 }
	 
//	 else if(action.equalsIgnoreCase("edit"))
//	 {
//	  forward = "/interviewerView.jsp";
//	  Integer id = Integer.parseInt(request.getParameter("interviewerId"));
//	  SearchCriteriaImpl criteria = new SearchCriteriaImpl();
//	  criteria.setInterviewerId(id);
//	  List<Interviewer> list = isaService.getBySearchCriteria(criteria);
//	  
//	  request.setAttribute("all", list);
//	  request.setAttribute("label","Update User");
//	  request.setAttribute("hlabel", "Edit User");
//	 }  
	 
	 else if(action.equalsIgnoreCase("delete"))
	 {
//	  int userId = Integer.parseInt(request.getParameter("userId"));
//	  dao.deleteUserById(userId);
//	  forward = "/index.jsp";
//	  request.setAttribute("users", dao.getAllUsers());  
		 schedule = new Schedule();
		 Integer id = Integer.parseInt(request.getParameter("scheduleId"));
		 schedule.setScheduleId(id);
		 isaService.delete(schedule);
		 forward ="/scheduleUpdate.jsp";
		 request.setAttribute("sched", isaService.getAll());
	 }
	 else if(action.equalsIgnoreCase("insert"))
	 {
		 schedule = new Schedule();
	  request.setAttribute("label","Add User");
	  request.setAttribute("hlabel", "Save User");
	  forward="/scheduleView.jsp";
	 }
	 
	 RequestDispatcher view = request.getRequestDispatcher(forward);
	 view.forward(request, response);	
	}
		
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{	
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
//	}
}
