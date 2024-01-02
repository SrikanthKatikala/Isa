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
				<c:forEach items="${intrvr}" var="intrvr">
					<tr>
						<td><c:out value="${intrvr.interviewerId}" /></td>
						<td><c:out value="${intrvr.interviewerName}" /></td>
						<td><c:out value="${intrvr.primarySkill}" /></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
