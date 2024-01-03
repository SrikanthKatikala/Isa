<%@page import="com.zettamine.isa.dto.Recruiter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
  <link rel="stylesheet" href="homepage.css">
</head>
<body>
	<header>
	<% Recruiter rec = (Recruiter) request.getAttribute("recr"); %>
		<div class = "user" > <a href="homepage.html"><img src="images/recruiter.jpeg"><%= rec.getRecruiterName() %></a>
		<h3><%=rec.getRecruiterId() %></h3>
		</div>
		
        <h1>Zettamine Labs Pvt Ltd</h1>
        <nav>
            <ul>
               <li><a href="homepage.html">Home</a></li>
                <li><a href="skill.jsp">Add Skill</a></li>
                <li><a href="applicants.jsp">Applicants</a></li>
                <li><a href="Interviewers.jsp">Interviewers</a></li>
                <li><a href="ScheduleInterview.jsp">Schedule Interview</a></li>
                <li><a href="InterviewSchedule.jsp">Interview schedule</a></li>
                <li><a href="logout.html">Logout</a></li>
            </ul>
        </nav>
    </header>
</body>
</html>