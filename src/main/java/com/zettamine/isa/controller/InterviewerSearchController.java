package com.zettamine.isa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONObject;

import com.zettamine.isa.dto.Applicant;
import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.service.ApplicantService;
import com.zettamine.isa.service.InterviewerService;
import com.zettamine.isa.service.IsaService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/searchInterviewer")
public class InterviewerSearchController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String iid = request.getParameter("interviewerId");
		System.out.println("iuw"+iid);
		String respText =" ";
		if (iid!=null || iid.length()>0) {
			Integer id = Integer.parseInt(iid);
			SearchCriteriaImpl criteria = new SearchCriteriaImpl();
			Interviewer interviewer = new Interviewer();
			criteria.setInterviewerId(id);
			interviewer.setInterviewerId(id);
			
			IsaService<Interviewer, SearchCriteriaImpl> isaService = new InterviewerService();
			List<Interviewer> list = isaService.getBySearchCriteria(criteria);
			Interviewer inter = list.get(0);
			System.out.println(inter);
			response.setContentType("application/json");
			JSONObject json = new JSONObject();
			
			json.put("interviewerId",inter.getInterviewerId());
			json.put("interviewerName", inter.getInterviewerName());
			json.put("email", inter.getEmail());
			json.put("skill", inter.getPrimarySkill());
			
			out.print(json);
			
		} else {
			out.print(respText);
		}
		
	}
}
