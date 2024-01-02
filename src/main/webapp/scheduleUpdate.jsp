<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<title>Interview Details</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0px;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 30px;
            box-shadow: 10px 10px 10px black;
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

        input,
        textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        span{
			color: red;
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
	<h1>Interview details</h1>
	<div id="wrapper">
		<table border=1 align=center>
			<thead>
				<tr>
					<th>Schedule Id</th>
					<th>Applicant Id</th>
					<th>Interviewer Id</th>
					<th>Recruiter Id</th>
					<th>Date</th>
					<th>Time</th>
					<th>Status</th>
					<th>Delete</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${sched}" var="sch">
					<tr>
						<td><c:out value="${sch.scheduleId}" /></td>
						<td><c:out value="${sch.applicantId}" /></td>
						<td><c:out value="${sch.interviewerId}" /></td>
						<td><c:out value="${sch.recruiterId}" /></td>
						<td><c:out value="${sch.interviewDate}" /></td>
						<td><c:out value="${sch.interviewTime}" /></td>
						<td><c:out value="${sch.status}" /></td>
						<!-- <td><a href="schedule?action=edit&scheduleId=<c:out value="${sch.scheduleId}"/>">Update</a></td> -->
						
						<td>
						<a href="schedule1?action=delete&scheduleId=<c:out value="${sch.interviewerId}"/>"
							onclick="return confirm('Do you want to delete the schedule ?')"><button class="a1">Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<hr>
		<!-- <a href="interviewer?action=insert">+ Schedule Interviewer</a> -->
	</div>
</body>
</html>