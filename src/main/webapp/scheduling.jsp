<%@page import="com.zettamine.isa.dto.Recruiter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scheduling </title>
<link rel="stylesheet" href="homepage.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style type="text/css">
form { 
	align: center;
	height: 480px;
	width: 460px;
	box-shadow: 0px 10px 10px black;
	border-radius: 20px;
	margin:auto;
}
table{
	margin:auto;
}
input {

	height: 30px;
	width: 200px;
	text-align: center;
	font-weight: bold;
	font-size: 20px;
	margin: auto;
	border-radius: 8px;
	margin: 10px;
}
button , #s1, #s2{

	height: 30px;
	width: 90px;
	background-color: lime;
	font-weight: bold;
	font-size: 15px; 
	border-radius: 5px;
	margin: auto;
}
</style>
</head>
<body>
<div>
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
	</div>
	<div>	
	<form action="schedule3" method="post">
	<h2 style="padding-top: 20px; margin-left: 100px;">Schedule Interview</h2>
	
			<table>
				<tr>
					<th><label>Enter Applicant Id:   </label></th>
					<td><input placeholder="Enter Applicant Id" type="number" name ="applicantId" required onblur="fetchData(this.value)"></td>
				</tr>
				<tr>
					<th><label>Enter Interviewer Id: </label></th>
					<td><input placeholder="Enter Interviewer Id " name="interviewerId"></td>
				</tr>
				<tr>
					<th><label>Enter Recruiter Id:  </label></th>
					<td><input placeholder="Enter recruiter Id" name="recruiterId"><br></td>
				</tr>
				<tr>
					<th><label>Enter Date:  </label></th>
					<td><input placeholder="Enter Date" type="Date" name="date"></td>
				</tr>
				<tr>
					<th><label>Enter Time: </label></th>
					<td><input placeholder="Enter Time" type="Time" name="time"></td>
				</tr>
				<tr>
					<th>Status: </th>
					<td><input type="text" name="status"></td>
				</tr>
				<tr>
					<th>
					<input type="submit" value="schedule" id="s1" > 
					</th>
					<th>
					<input type="reset" value="clear" id="s2">
					</th>
				</tr>
			</table>
			<br>
	</form>
	
	</div>
	<hr>
	<div id="t1" style="border:2px solid black">
		<h1 id="x1"></h1>
	</div>
	<script>
	   var xhttp;
	   var obj ;
        function fetchData(id) {
            xhttp = new XMLHttpRequest();
            
            xhttp.open("GET", "schedule2?applicantId="+id, true);
            xhttp.onreadystatechange = getInterviewerDetails
            xhttp.send();
        }
        function getInterviewerDetails(){
			if(xhttp.readyState == 4 && xhttp.status==200){	
			var resp = xhttp.responseText;			
				console.log(resp);
				if(resp.length > 0){
					obj = JSON.parse(resp);
					console.log(obj)		
					arrayToTable(obj);
					//document.getElementById("x1").innerHTML=obj;
				}		
			}
        }
        var tb= document.getElementById("t1");
        
        function arrayToTable(data) {
            // Create the table element
            var table = document.createElement('table');

            // Create the header row
            var headerRow = table.insertRow(0);
            for (var key in data[0]) {
                var th = document.createElement('th');
                th.innerHTML = key;
                headerRow.appendChild(th);
            }

            for (var i = 0; i < data.length; i++) {
                var row = table.insertRow(i + 1);

                for (var key in data[i]) {
                    var cell = row.insertCell();
                    cell.innerHTML = data[i][key];
                }
            }

            document.body.appendChild(table);
        }
        
    </script>
</body>
</html>