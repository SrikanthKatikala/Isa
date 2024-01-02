<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" />

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

<title>Interview Schedule</title>

<script>
	$(function() {
		$('input[name=dob]').datepicker();
	});
</script>
</head>
<body>
	<div id="wrapper">
		<h1>
			Interviewer Schedule 
			<c:out value="${hlabel}" />
		</h1>
		<br>
		<br>
		<form method="POST" action='schedule' name="frmAddUser">
			<table style="width: 500px">
				<tr>
					<td>Schedule Id: </td>
					<td><input type="number" readonly="readonly" name="interviewerId"
						value="<c:out value="${sch.scheduleId}" />" /></td>
				</tr>

				<tr>
					<td>Applicant Id: </td>
					<td><input type="number" name="applicantId" required="required"
						value="<c:out value="${sch.applicantId}"/>"> <span
						style="color: red">*</span></td>
				</tr>

				<tr>
					<td>Interviewer Id: </td>
					<td><input type="number" name="interiewerId"
						value="<c:out value="${sch.interviewerId}" />" /></td>
				</tr>

				<tr>
					<td>Recruiter Id: </td>
					<td>
						<input type="number" name="recruiterId" value="<c:out value="${sch.recruiterId}" />" />
					</td>
				</tr>

				<tr>
					<td>Interview date: </td>
					<td><input type="date" name="date" value="<c:out value="${sch.interviewDate}" />" /></td>
				</tr>
				<tr>
					<td>Interview time: </td>
					<td><input type="time" name="time" value="<c:out value="${sch.interviewTime}" />" /></td>
				</tr>
				<tr>
					<td>Status: </td>
					<td><input type="text" name="status" value="<c:out value="${sch.status}" />" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="${label}"}" ></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>