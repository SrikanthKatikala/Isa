<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<title>Interviewer</title>
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
	<div id="wrapper">
		<h1>Details Of interviewer</h1><br>
		<a href="interviewer?action=insert" ><button id="b1" class="a1">New Interviewer</button></a> <br>
		<table align=center>
			<thead>
				<tr>
					<th>Interviewer Id</th>
					<th>Interviewer Name</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Skill</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${intrvr}" var="intrvr">
					<tr>
						<td><c:out value="${intrvr.interviewerId}" /></td>
						<td><c:out value="${intrvr.interviewerName}" /></td>
						<td><c:out value="${intrvr.email}" /></td>
						
						<td><c:out value="${intrvr.phoneNumber}" /></td>
						<td><c:out value="${intrvr.primarySkill}" /></td>
						<td>
						  <a href="interviewer?action=edit&interviewerId=<c:out value="${intrvr.interviewerId}"/>"><button>Update</button></a></td>
						<td>
						<a href="interviewer?action=delete&interviewerId=<c:out value="${intrvr.interviewerId}"/>"
							onclick="return confirm('Do you want to delete the interviewer?')"><button>Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>