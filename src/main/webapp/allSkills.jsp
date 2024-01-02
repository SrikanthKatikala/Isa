<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="dashboard.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table Search</title>
    
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        input[type="text"] {
            padding: 5px;
        }
    </style>
</head>
<body>
<header>
		<div class = "user" > <a href="#"><img src="images/user.png">userName</a></div>
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
    <h2>Table with Search</h2>

    <input type="text" id="nameSearch" onkeyup="searchTable()" placeholder="Search by Name">
    <input type="text" id="ageSearch" onkeyup="searchTable()" placeholder="Search by Age">

    <table border="1">
			<thead>
				<tr>
					<th>Skill Id</th>
					<th>Skill Desc</th>
				</tr>
			</thead>

			<tbody>
			<c:forEach items="${allSkills}" var="skill">
					<tr>
						<td><c:out value="${skill.skillId}" /></td>
						<td><c:out value="${skill.skillDesc}" /></td>
					</tr>
			</c:forEach>
			</tbody>
</table>
	<!--  
    <script>
        function searchTable() {
            var inputName, inputAge, filterName, filterAge, table, tr, tdName, tdAge, i, txtValueName, txtValueAge;

            inputName = document.getElementById("nameSearch");
            inputAge = document.getElementById("ageSearch");
            filterName = inputName.value.toUpperCase();
            filterAge = inputAge.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");

            for (i = 0; i < tr.length; i++) {
                tdName = tr[i].getElementsByTagName("td")[0];
                tdAge = tr[i].getElementsByTagName("td")[1];

                if (tdName || tdAge) {
                    txtValueName = tdName.textContent || tdName.innerText;
                    txtValueAge = tdAge.textContent || tdAge.innerText;

                    if ((txtValueName.toUpperCase().indexOf(filterName) > -1) &&
                        (txtValueAge.toUpperCase().indexOf(filterAge) > -1)) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
	-->
</body>
</html>
    
    