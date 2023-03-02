<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<center><h1>Edit Student Page</h1><hr><hr>
	<div class="container">
		<form action="./update-student" method="POST">
			<label>Student Id</label><br>
			<input type="number" name="studentId" >
			<br><br>	
			
			<label>Name</label><br>
			<input type="text" name="name" >
			<br><br>			
			
			<label>Age</label><br>
			<input type="number" name="age" >
			<br><br>
			
			<label>Mobile Number</label><br>
			<input type="number" name="mbl" >
			<br><br>
			
			<label>Password</label><br>
			<input type="password" name="password" >
			<br><br>
			
			<input type="submit" value="Update Student">
			
		</form>
	</div></center>
</body>
</html>