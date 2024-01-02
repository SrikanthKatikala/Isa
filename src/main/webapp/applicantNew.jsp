<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Applicant Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-size: 16px;
        }
        h2{
			color: red;
			text-align: center;
			margin-top: 35%;
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
    </style>
</head>
<body>
	<!-- <form action="" method="post" >
		<input placeholder="Applicant Name" name="name">
		<input placeholder="Email" name="email">
		<input placeholder="Phone number" name="mobile">
		<input placeholder="Highest qualification" name="qualification">
		<input placeholder="Applicant remarks" name="remarks">
		<input placeholder="Primary Skill" name="skill">
		<input type="submit">
	</form> -->
	<form action="#" method="post">
		<h2>Registration form</h2>
        <label for="applicantName">Applicant Name:<span>*</span></label>
        <input type="text" id="app_name" name="name" required>

        <label for="email">Email:<span>*</span></label>
        <input type="email" id="app_email" name="email" required>

        <label for="phoneNumber">Phone Number:<span>*</span></label>
        <input type="tel" id="app_phoneNumber" name="mobile" required>

        <label for="highestQualification">Highest Qualification:<span>*</span></label>
        <input type="text" id="highestQualification" name="qualification" required>
		
		<label for="remarks">Remarks:</label>
        <textarea id="remarks" name="remarks" rows="4"></textarea>
		
        <label for="Skill">Skill:<span>*</span></label>
        <input type="number" id="app_skill" name="skill" required>

        <button type="submit">Submit</button>          <button type="reset">Clear</button>
        
    </form>
</body>
</html>