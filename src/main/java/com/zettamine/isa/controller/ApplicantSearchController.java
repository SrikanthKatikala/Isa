package com.zettamine.isa.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONObject;

import com.zettamine.isa.dto.Applicant;
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.service.ApplicantService;
import com.zettamine.isa.service.IsaService;

@WebServlet("/applicantSearch")
public class ApplicantSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String aid = request.getParameter("applicantId");
		String respText ="";
		if (aid!=null || aid.length()>0) {
			Integer id = Integer.parseInt(aid);
			SearchCriteriaImpl criteria = new SearchCriteriaImpl();
			Applicant applicant = new Applicant();
			criteria.setApplicantId(id);
			applicant.setApplicantId(id);
			IsaService<Applicant, SearchCriteriaImpl> isaService = new ApplicantService();
			List<Applicant> list = isaService.getBySearchCriteria(criteria);
			Applicant apl = list.get(0);
			System.out.println(apl);
			response.setContentType("application/json");
			JSONObject json = new JSONObject();
			
			json.put("applicantId", apl.getApplicantId());
			json.put("applicantName", apl.getApplicantName());
			json.put("email", apl.getEmail());
			json.put("skill", apl.getPrimarySkill());
			
			out.print(json);
			
		} else {
			out.print(respText);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
