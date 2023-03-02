<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>display</title>
</head>
<body>
	
	<center><h1>Display Student</h1><hr><hr>
	<c:choose>
		<c:when test="${ msg.getClass().getSimpleName().equals(\"String\")}">
			<h2>${msg }</h2>
		</c:when>
		<c:when test="${ msg.getClass().getSimpleName().equals(\"CurdDto\")}">
			<table border="1" align="center">
				<tr>
					<th>Student Id</th>
					<th>Name</th>
					<th>Age</th>
					<th>Mobile Number</th>
				</tr>
				<tr>
					<td>${ msg.studentId }</td>
					<td>${ msg.name }</td>
					<td>${ msg.age }</td>
					<td>${ msg.mbl }</td>
				</tr>
			</table>
		</c:when>
	</c:choose>
	</center>

</body>
</html>