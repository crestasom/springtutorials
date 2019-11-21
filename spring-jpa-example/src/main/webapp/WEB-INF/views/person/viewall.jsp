<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>

<html>
<head>
<Title>Person List</Title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>

<body>
	<a href="/person/add">Add New</a>
	<br>
	<table class="form">
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Email</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		<c:forEach items="${personList}" var="person">
			<tr>
				<td><c:out value="${person.firstName}" /></td>
				<td><c:out value="${person.lastName}" /></td>
				<td><c:out value="${person.email}" /></td>
				<td><a href="/person/update/<c:out value="${person.id}" />">Update</a></td>
				<td><a href="/person/delete/<c:out value="${person.id}" />"
					onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>