package com.zettamine.isa.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.service.InterviewerService;
import com.zettamine.isa.service.IsaService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/interviewer")
public class InterviewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static IsaService<Interviewer, SearchCriteriaImpl> isaService;
	private static Interviewer interviewer;
	@Override
	public void init(ServletConfig config) throws ServletException {
		isaService = new InterviewerService();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 String forward="";	 
	 String action = request.getParameter("action");	 
	 if(action==null)
	 {
	   forward = "/interviewer.jsp";
	   request.setAttribute("intrvr", isaService.getAll());
	 }
	 
	 else if(action.equalsIgnoreCase("edit"))
	 {
	  forward = "/interviewerView.jsp";
	  String iId = request.getParameter("interviewerId");
	  Integer id = Integer.parseInt(iId);
	  interviewer.setInterviewerId(id);
	  isaService.update(interviewer, iId);
	  
	  request.setAttribute("all", isaService.getAll());
	  request.setAttribute("label","Update Interviewer");
	  request.setAttribute("hlabel", "Edit Interviewer");
	 }  
	 
	 else if(action.equalsIgnoreCase("delete"))
	 {
		 interviewer = new Interviewer();
		 System.out.println(request.getParameter("interviewerId"));
		 Integer id = Integer.parseInt(request.getParameter("interviewerId"));
		 System.out.println(interviewer);
		 interviewer.setInterviewerId(id);
		 System.out.println(interviewer);
		 isaService.delete(interviewer);
		 forward ="/interviewer.jsp";
		 request.setAttribute("intrvr", isaService.getAll());
	 }
	 else if(action.equalsIgnoreCase("insert"))
	 {
		 interviewer = new Interviewer();
	  request.setAttribute("label","Add User");
	  request.setAttribute("hlabel", "Save User");
	  forward="/interviewerView.jsp";
	 }
	 
	 RequestDispatcher view = request.getRequestDispatcher(forward);
	 view.forward(request, response);	
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	

		interviewer = new Interviewer();
		interviewer.setInterviewerName(request.getParameter("name"));
		interviewer.setEmail(request.getParameter("email"));
		interviewer.setPhoneNumber(request.getParameter("mobile"));
		int int1 = Integer.parseInt(request.getParameter("skill"));
		interviewer.setPrimarySkill(int1);	 
	 String interviewerId = request.getParameter("interviewerId");
	 if(interviewerId == null || interviewerId.isEmpty())
	 {
		isaService.save(interviewer);
	 }
	 else
	 {
		interviewer.setInterviewerId(Integer.parseInt(interviewerId));
		isaService.update(interviewer, interviewerId);
	 }
	 RequestDispatcher view = request.getRequestDispatcher("/interviewerView.jsp");
	 request.setAttribute("intrvr", isaService.getAll());
	 view.forward(request, response);
	}

}
