<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Person</title>
</head>
<body>


	<form action="add" method="post">
		Name:<input type="text" name="name" /><br /> Email:<input
			type="text" name="email" /><br /> <input type="submit"
			name="submit" value="Save" /><br />
	</form>
</body>
</html>