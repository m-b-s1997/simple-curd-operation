<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h1>Agent adding page</h1>
	<hr><hr>
	<div class="/container">
		<form action="student-add" method="get">
			<label>Student name</label><br>
			<input type="text" name="name">
			<br><br>
	
			<label>Password</label><br>
			<input type="password" name="password">
			<br><br>
			
			<label>Age</label><br>
			<input type="number" name="age">
			<br><br>
			
			<label>Mobile Number </label><br>
			<input type="number" name="mbl">
			<br><br>
			
			<input type="submit" value="Register">
			</form></div></center>
		<a href="./logout">Logout</a>
</body>
</html>