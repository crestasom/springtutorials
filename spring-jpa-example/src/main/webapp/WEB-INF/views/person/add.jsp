<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Add New Person</title>
</head>
<body>
	<h1>Add New Person</h1>
	<hr>

	<div class="form">
		<form action="/person/add" method="post" onsubmit="return validate()">
			<table>
				<tr>
					<td>Enter First Name</td>
					<td><input id="first_name" name="first_name"
						value="${person.firstName}"></td>
				</tr>
				<tr>
					<td>Enter Last Name</td>
					<td><input id="last_name" name="last_name"
						value="${person.lastName}"></td>
				</tr>
				<tr>
					<td>Enter Email</td>
					<td><input id="email" name="email" value="${person.email}"></td>
				</tr>
				<tr>
					<td>Select Department</td>
					<td><select name="department">
							<c:forEach items="${department}" var="dept">
								<option value="${dept.id }">${ dept.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>