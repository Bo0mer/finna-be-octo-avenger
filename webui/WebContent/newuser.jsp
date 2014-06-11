<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="templates/header.jsp" %>
	<form method="post" action="CreateUser">
		<label>Username:</label> <input type="text" name="username" required> <br />
		<label>Password:</label> <input type="password" name="password" required> <br />
		<label>Name:</label> <input type="text" name="name" required> <br /> 
		<label>E-mail:</label> <input type="text" name="email" required> <br /> <input type="submit">
		<br />
	</form>
</body>
</html>