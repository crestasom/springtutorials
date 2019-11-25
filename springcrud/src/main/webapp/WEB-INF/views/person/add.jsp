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
	<c:set var="act" value="add" />
	<c:if test="${action!=act}">
		<c:set var="var_id" value="${person.id }" />
		<c:set var="var_name" value="${person.name }" />
		<c:set var="var_email" value="${person.email }" />
	</c:if>

	<form action="${action}" method="post">
		Name:<input type="text" name="name" value="${var_name }" /><br />
		Email:<input type="text" name="email" value="${var_email }" /><br />
		<input type="submit" name="submit" value="Save" /><br />
	</form>
</body>
</html>