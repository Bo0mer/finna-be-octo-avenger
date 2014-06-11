<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new project</title>
</head>
<body>
<%@ include file="templates/header.jsp" %>
	<form method="post" action="CreateProject">
		<label>Project name: </label>
		<input type="text" name="name">
		<input type="submit">
	</form>
</body>
</html>