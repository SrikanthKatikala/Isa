package com.zettamine.isa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;

import com.zettamine.isa.dto.Applicant;
import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.service.ApplicantService;
import com.zettamine.isa.service.IsaService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/applicant")
public class ApplicantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Applicant applicant;
	public static IsaService<Applicant, SearchCriteriaImpl> isaService;
	
	public void init(ServletConfig config) throws ServletException {
		isaService = new ApplicantService();
 		applicant= new Applicant();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";	 
		 String action = request.getParameter("action");	 
		 if(action==null)
		 { 	
		   List<Applicant> all = isaService.getAll();
		   request.setAttribute("all", all);
		   forward = "/applicantView.jsp";
		 }
		 
		 else if(action.equalsIgnoreCase("edit"))
		 {
			 SearchCriteriaImpl criteria = new SearchCriteriaImpl();
			 applicant= new Applicant();
		  String id = request.getParameter("applicantId");
		  Integer aId = Integer.parseInt(id);
		  applicant.setApplicantId(aId);
		  criteria.setApplicantId(aId);
		  isaService.update(applicant, id);
		  List<Applicant> list = isaService.getBySearchCriteria(criteria);
		  applicant =list.get(0);
		  
		  request.setAttribute("apl", applicant);
		  forward = "/update.jsp";
		 }  
		 
		 else if(action.equalsIgnoreCase("delete"))
		 {
			 applicant= new Applicant();
		  String applicantId = request.getParameter("applicantId");
		  Integer id = Integer.parseInt(applicantId);
		  applicant.setApplicantId(id);
		  isaService.delete(applicant);
		  forward = "/applicantView.jsp";
		  request.setAttribute("all", isaService.getAll()); 
		 
		 }
		 else if(action.equalsIgnoreCase("insert"))
		 {
			 applicant= new Applicant();
			 applicant.setApplicantId(null);
			 
		  forward="/update.jsp";
		 }
		 
		 RequestDispatcher view = request.getRequestDispatcher(forward);
		 view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String email=request.getParameter("email");
		String mobile = request.getParameter("phone");
		String education = request.getParameter("qualification");
		String remarks = request.getParameter("remarks");
		String sk = request.getParameter("skill");
		Integer skill=Integer.parseInt(sk);
		String id = request.getParameter("applicantId");
		 applicant = new Applicant();
		 applicant.setApplicantName(name);
		 applicant.setEmail(email);
		 applicant.setPhoneNumber(mobile);
		 applicant.setHighestQualification(education);
		 applicant.setApplicantRemarks(remarks);
		 applicant.setPrimarySkill(skill);
		 
		 if (id==null || id.isEmpty()) {
			 isaService.save(applicant);
		} else {
			SearchCriteriaImpl criteria = new SearchCriteriaImpl();
			 applicant.setApplicantId(Integer.parseInt(id));
			 isaService.update(applicant, id);
			 
			  criteria.setApplicantId(Integer.parseInt(id));
			  List<Applicant> list = isaService.getBySearchCriteria(criteria);
			  applicant =list.get(0);
			
		}
		 
		 PrintWriter out = response.getWriter();
		 request.setAttribute("app", applicant);
		 request.setAttribute("all", isaService.getAll());
		 RequestDispatcher view = request.getRequestDispatcher("/applicantView.jsp");
		 view.include(request, response);
		
	}

}
