package com.zettamine.isa.controller;

import java.io.IOException;
import java.util.List;

import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.service.InterviewerService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/schedule2")
public class SearchInterviewerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String cId = req.getParameter("cId");
		Integer id = Integer.parseInt(cId);
		InterviewerService service = new InterviewerService();
		List<Interviewer> list = service.getInterviewerByApplicantId(id);
		req.setAttribute("intrvr", list);
		RequestDispatcher rd = req.getRequestDispatcher("viewInterviewer.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
