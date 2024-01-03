<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applicant Table</title>
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
			width: 140px;
		}
    </style>
</head>

<body>

	<div align="center">
	
		<h1>Details Of Applicants</h1>
		<a style="float: right" href="applicant?action=insert"><button id="b1" class="a1">New Applicant</button></a> <br>
		<table border="1" align=center>
			<thead>
				<tr>
					<th>Applicant Id</th>
					<th>Applicant Name</th>
					<th>Email</th>
					<th>Phone number</th>
					<th>Qualification</th>
					<th>remarks</th>
					<th>Skill</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${all}" var="apl">
					<tr>
						<td><c:out value="${apl.applicantId}"/></td>
						<td><c:out value="${apl.applicantName}" /></td>
						<td><c:out value="${apl.email}"/></td>
						<td><c:out value="${apl.phoneNumber}"/></td>
						<td><c:out value="${apl.highestQualification}" /></td>
						<td><c:out value="${apl.applicantRemarks}"/></td>
						<td><c:out value="${apl.primarySkill}"/></td>
						<td>
						  <a href="applicant?action=edit&applicantId=${apl.applicantId}"><button>Update</button></a></td>
						<td>
						<a href="applicant?action=delete&applicantId=${apl.applicantId}" onclick="return confirm('Do you want to delete the user?')"><button>Delete</button></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="homepage.html" style="margin-top: 100px"><button>Home</button></a>
	</div>
</body>
</html>