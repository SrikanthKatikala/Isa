<%@page import="com.zettamine.isa.dto.Interviewer"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div>
		<table border=1 align=center>
			<thead>
				<tr>
					<th>Interviewer Id</th>
					<th>Interviewer Name</th>
					<th>Skill</th>
				</tr>
			</thead>

			<tbody>
			<%
			List<Interviewer> list=(List<Interviewer>) request.getAttribute("intrvr");
			for(Interviewer intr:list){
			%>
				<tr>
					<td><%= intr.getInterviewerId() %></td>
					<td><%= intr.getInterviewerName() %></td>
					<td><%= intr.getPrimarySkill() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
