<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Page</title>
</head>
<body>

	<center><h1>All Student</h1>
	<hr><hr>

	<table border="1" align="center">
		<tr>
			<th>Student Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Mobile Number</th>
			<th colspan="2">Action</th>
		</tr>
		
		<c:forEach var="student" items="${students}">
			<tr>
				<td>${ student.studentId }</td>
				<td>${ student.name }</td>
				<td>${ student.age }</td>
				<td>${ student.mbl }</td>
				<td><a href='./delete?studentId=${ student.studentId }'>DELETE</a></td>
			</tr>
		</c:forEach>
	</table>
	</center>
	<a href="./logout">Logout</a>
</body>
</html>