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
	<h3>
		<a href="add">Add New Person</a>
	</h3>
	<table>
		<thead>
			<td>Name</td>
			<td>Email</td>
			<td>Update</td>
			<td>Delete</td>
		</thead>
		<c:forEach var="person" items="${persons }">
			<tr>
				<td>${person.name}</td>
				<td>${person.email}</td>
				<td><a href="update/${person.id }">Update</a></td>
				<td><a href="delete/${person.id }"
					onclick="return confirm('Are you sure you want to delete this person?')">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>