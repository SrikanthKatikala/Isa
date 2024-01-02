<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Skills</title>
 <link rel="stylesheet" href="homepage.css">
</head>
<body>
<div>
	<header>
		<div class = "user" > <a href="#"><img src="images/user.png">userName</a></div>
        <h1>Zettamine Labs Pvt Ltd</h1>
		<nav>
            <ul>
               <li><a href="homepage.html">Home</a></li>
                <li><a href="skills.jsp">Add Skill</a></li>
                <li><a href="applicant.html">Applicants</a></li>
                <li><a href="interview.html">Interviewers</a></li>
                <li><a href="interviewSchedule.html">Interview Details</a></li>
                <li><a href="">Schedule</a></li>
                <li><a href="logout.html">Logout</a></li>
            </ul>
        </nav>
      </header>
</div>
	<h1>Add skill</h1>
	<form action="addSkill" method="post">
		<input placeholder="add skill" name="skill" required><br>
		<input type="submit">
	</form>
	<br>
	<form action="addSkill" method="get" style="margin: auto">
		<input type="submit" value="View All">
	</form>
	
	<script>
		
	</script>
</body>
</html>