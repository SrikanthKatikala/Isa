<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Skills</title>
 <link rel="stylesheet" href="homepage.css">
<style>
        form {
            align-items: center;
            justify-content: center;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
         input {
            width: 40%;
            padding: 8px;
            margin-left:30%;
            box-sizing: border-box;
        }
        label{
            width: 40%;
            padding: 8px;
            margin-left:30%;
            margin-bottom:10px; 
        }
        span{
        color:red;
        }
       #submit{
       		color: blue;
            font-weight: bold;
             background-color: rgb(128, 255, 128);
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
	<form action="addSkill" method="post">
		<label for="applicantName">Add Skill:<span>*</span></label><br>
		<input type="text" placeholder="Add Skill" name="skill" required><br>
		<input  type="submit" id = "submit" value="Add Skill">
	</form>
</div>
<div>
	<form action="addSkill" method="get" style="margin: auto">
		<input type="submit" id= "submit" value="View All">
	</form>
</div>
	
	<script>
		
	</script>
</body>
</html>