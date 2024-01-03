<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="homepage.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table Search</title>
    
     <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
      th {
            background-color: rgb(128, 255, 128);
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
   
</head>
<body>
<header>
		
        <h1>Zettamine Labs Pvt Ltd</h1>
		<nav>
            <ul>
               <li><a href="homepage.html">Home</a></li>
                <li><a href="skills.jsp">Add Skill</a></li>
                <li><a href="applicant.html">Applicants</a></li>
                <li><a href="interview.html">Interviewers</a></li>
                <li><a href="interviewSchedule.html">Interview Details</a></li>
                <li><a href="scheduling.jsp">Schedule</a></li>
                <li><a href="logout.html">Logout</a></li>
            </ul>
        </nav>
      </header>
    <table border="1">
			<thead>
				<tr>
					<th>Skill Id</th>
					<th>Skill Desc</th>
					<th>Delete</th>
				</tr>
			</thead>

			<tbody>
			<c:forEach items="${allSkills}" var="skill">
					<tr>
						<td><c:out value="${skill.skillId}" /></td>
						<td><c:out value="${skill.skillDesc}" /></td>
						<td>
						<a href="addSkill?action=delete&skillId=${skill.skillId}" onclick="return confirm('Do you want to delete the skill?')"><button>Delete</button></a>
						</td>
					</tr>
			</c:forEach>
			</tbody>
</table>
	
</body>
</html>
    
    