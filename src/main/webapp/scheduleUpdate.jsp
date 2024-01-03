<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<title>Interview Details</title>
<style>
        body {
            text-align: center;
            background-color: #f4f4f4;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-size: 16px;
        }
        h2{
			color: red;
			text-align: center;
		}
        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top:50px;
        }

		table,td,th{
			border-collapse:collapse;
			border: 3px solid black;
			border-radius: 10px;
		}
		td,th{
			padding:5px;
		}
		.a1{
			background-color: lime;
			height: 35px;
			width: 100px;
			border-radius: 5px;
			font-weight:bold;
			box-shadow: 0px 5px 5px black;
			color:black;
		}
		#b1{
			background: cyan;
			margin-bottom: 30px;
			font-size: 15px;
			width: 150px;
			float:right;
		}
    </style>
</head>

<body>
	<div style="width:100%">
		<h1>Interview details</h1>
	</div>
	<div>
		<table border=1 align=center>
			<thead>
				<tr>
					<th>Schedule Id</th>
					<th>Applicant Name</th>
					<th>Interviewer Name</th>
					<th>Recruiter Name</th>
					<th>Date</th>
					<th>Time</th>
					<th>Status</th>
					
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${sched}" var="sch">
					<tr>
						<td><c:out value="${sch.scheduleId}" /></td>
						<td><c:out value="${sch.applicantName}" /></td>
						<td><c:out value="${sch.interviewerName}" /></td>
						<td><c:out value="${sch.recruiterName}" /></td>
						<td><c:out value="${sch.interviewDate}" /></td>
						<td><c:out value="${sch.interviewTime}" /></td>
						<td><c:out value="${sch.status}" /></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="homepage.html" style="margin-top: 100px"><button>Home</button></a>
	</div>
</body>
</html>