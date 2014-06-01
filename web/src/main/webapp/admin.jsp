<%@ page import="com.finna.be.octo.avenger.core.db.dao.impl.UserDAO"%>
<%@ page import="com.finna.be.octo.avenger.core.db.model.DBUser"%>
<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Admin panel</title>
</head>
<body>


	<form method="post" action="CreateUserServlet">
		Username: <input type="text" name="username"> <br />
		Password: <input type="password" name="password"> <br />
		Name: <input type="text" name="name"> <br /> E-mail: <input
			type="text" name="email"> <br /> <input type="submit">
		<br />
	</form>
</body>
</html>