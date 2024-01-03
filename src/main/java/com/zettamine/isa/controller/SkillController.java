package com.zettamine.isa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.dto.Skill;
import com.zettamine.isa.service.IsaService;
import com.zettamine.isa.service.SkillServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addSkill")
public class SkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Skill skill ;
	public static IsaService<Skill, SearchCriteriaImpl> isaService;
       
 	public void init(ServletConfig config) throws ServletException {
 		isaService = new SkillServiceImpl();
 		skill= new Skill();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";	 
		String action = request.getParameter("action");
		
		if(action==null) {
			response.setContentType("text/html");
			
			List<Skill> all = isaService.getAll();
			request.setAttribute("allSkills", all);
			forward= "/allSkills.jsp";
		}
		
		else if(action.equalsIgnoreCase("delete")) {
			
			String id = request.getParameter("skillId");
			Integer sId = Integer.parseInt(id);
			skill.setSkillId(sId);
			request.setAttribute("allSkills", isaService.getAll());
			isaService.delete(skill);	
			forward="/allSkills.jsp";
		}
			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
		requestDispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name =  request.getParameter("skill");
		skill.setSkillDesc(name);
		isaService.save(skill);
		String skillDesc = skill.getSkillDesc();
		System.out.println(skillDesc);
		request.setAttribute("allSkills", isaService.getAll());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("skills.jsp");
		requestDispatcher.forward(request, response);
	}

}
