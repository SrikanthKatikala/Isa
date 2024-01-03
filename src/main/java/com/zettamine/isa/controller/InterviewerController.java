package com.zettamine.isa.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

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
public class InterviewerController extends HttpServlet {
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
		 SearchCriteriaImpl criteria = new SearchCriteriaImpl();
		 interviewer =  new Interviewer();
	  forward = "/interviewerView.jsp";
	  String iId = request.getParameter("interviewerId");
	  Integer id = Integer.parseInt(iId);
	  interviewer.setInterviewerId(id);
	  criteria.setInterviewerId(id);
	  List<Interviewer> list = isaService.getBySearchCriteria(criteria);
	 
	  interviewer = list.get(0);
	  isaService.update(interviewer, iId);
	  request.setAttribute("intrvr", list.get(0));
	 }
	 
	 else if(action.equalsIgnoreCase("delete"))
	 {
		 interviewer = new Interviewer();
		 System.out.println(request.getParameter("interviewerId"));
		 Integer id = Integer.parseInt(request.getParameter("interviewerId"));
		 interviewer.setInterviewerId(id);

		 isaService.delete(interviewer);
		 forward ="/interviewer.jsp";
		 request.setAttribute("intrvr", isaService.getAll());
	 }
	 else if(action.equalsIgnoreCase("insert"))
	 {
	  forward="/interviewerView.jsp";
	 }
	 
	 RequestDispatcher view = request.getRequestDispatcher(forward);
	 view.include(request, response);	
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	

		interviewer = new Interviewer();
		interviewer.setInterviewerName(request.getParameter("name"));
		interviewer.setEmail(request.getParameter("email"));
		interviewer.setPhoneNumber(request.getParameter("mobile"));
		interviewer.setPrimarySkill(Integer.parseInt(request.getParameter("skill")));
		String id = request.getParameter("interviewerId");
		if (id==null || id.isEmpty()) {
			isaService.save(interviewer);  
		}else {
			SearchCriteriaImpl criteria = new SearchCriteriaImpl();
			  Integer Iid = Integer.parseInt(id);
			  interviewer.setInterviewerId(Iid);
			  isaService.update(interviewer, id);
			  criteria.setInterviewerId(Iid);
			  List<Interviewer> list = isaService.getBySearchCriteria(criteria);
			  interviewer = list.get(0);
		}
	 RequestDispatcher view = request.getRequestDispatcher("/interviewerView.jsp");
	 request.setAttribute("intrv", isaService.getAll());
	 view.include(request, response);
	}

}
