package com.zettamine.isa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.service.InterviewerService;

import jakarta.servlet.RequestDispatcher;
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
		PrintWriter out = resp.getWriter();
		String aId = req.getParameter("applicantId");
		String respText="";
		if (aId!=null) {
			Integer id = Integer.parseInt(aId);
			InterviewerService service = new InterviewerService();
			List<Interviewer> list = service.getInterviewerByApplicantId(id);
			req.setAttribute("intrvr", list);
			resp.setContentType("application/json");
			JSONArray array = new JSONArray();
			for(int i=0; i<list.size(); i++) {
				JSONObject json = new JSONObject();
				for (Interviewer obj : list) {
					json.put("interviewerId", obj.getInterviewerId());
					json.put("interviewerName", obj.getInterviewerName());
					json.put("email", obj.getEmail());
					json.put("skill", obj.getPrimarySkill());
				}
				array.put(json);
			}
			out.print(array);
		} else {
			out.print(respText);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
