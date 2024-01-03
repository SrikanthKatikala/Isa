package com.zettamine.isa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.zettamine.isa.dto.Recruiter;
import com.zettamine.isa.dto.SearchCriteria;
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.service.IsaService;
import com.zettamine.isa.service.RecruiterServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class RecruiterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IsaService<Recruiter, SearchCriteriaImpl> isaSurvice;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		isaSurvice = new RecruiterServiceImpl();
		SearchCriteriaImpl criteria = new SearchCriteriaImpl();
		criteria.setUserName(name);
		criteria.setUserPassword(password);
		List<Recruiter> list = isaSurvice.getBySearchCriteria(criteria);
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		if (list.size()>0) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage.html");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			writer.println("<p style=color:red >Operation failed...!!!</p>");
			requestDispatcher.include(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
