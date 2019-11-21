<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person List</title>
</head>
<body>
	<H3>Person List</H3>
	<table>
		<tr>
			<td>Name</td>
			<td>Email</td>
		</tr>
		<c:forEach var="person" items="${persons}">
			<tr>
				<td>${person.name}</td>
				<td>${person.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>