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

<title>ZETTAMINT</title>
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
		.a1{
			background-color: lime;
			height: 35px;
			width: 100px;
			border-radius: 5px;
			font-weight:bold;
			box-shadow: 0px 5px 5px black;
		}
    </style>
</head>
<body>
	<div>
		<h1>  Applicant 
		</h1>
		<form method="post" action="applicant">
		<h2>Applicant </h2>
		
			<table style="width: 500px">
				<tr>
					<td>Applicant Id </td>
					<td><input type="hidden" name="applicantId" value="${apl.applicantId}"></td>
				</tr>
				<tr>
					<td>Applicant Name :<span
						style="color: red">*</span></td>
					<td><input type="text" name="name" required="required" value="<c:out value="${apl.applicantName}"/>"></td>
				</tr>
				<tr>
					<td>Email :<span
						style="color: red">*</span></td>
					<td><input type="email" name="email" required
						value="<c:out value="${apl.email}" />" /></td>
				</tr>
				<tr>
					<td>Phone Number:<span
						style="color: red">*</span> </td>
					<td><input type="tel" name="phone" required
						value="<c:out value="${apl.phoneNumber}" />" /></td>
				</tr>
				<tr>
					<td>Highest Qualification: <span
						style="color: red">*</span></td>
					<td><input type="text" name="qualification" required
						value="<c:out value="${apl.highestQualification}" />" />
						</td>
				</tr>
				<tr>
					<td>Remarks: </td>
					<td><input type="text" name="remarks"
						value="<c:out value="${apl.applicantRemarks}" />" /></td>
				</tr>
				<tr>
					<td>Primary Skills: <span
						style="color: red">*</span></td>
					<td><input type="number" name="skill" required
						value="<c:out value="${apl.primarySkill}" />" /></td>
				</tr>

				<tr>
					<td align="center"><input type="submit" class="a1"></td>
					<td align="center"><input type="reset" value="Clear" class="a1"></td>
				</tr>
				<tr>
					
				</tr>
			</table>
			
		</form>
		<td colspan=2><a href="homepage.html" style="margin-left: 210px;margin-top:50px;"><button>Home</button></a></td>
	</div>
</body>
</html>