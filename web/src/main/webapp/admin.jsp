
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

	<%
	if("POST".equals(request.getMethod())){
		String username =  request.getParameter("username");
		//Validations
		  if (!username.matches("[a-zA-Z0-9]*")) {
			 out.println("User not added. Only letters are allowed!");
		  }
		  String password = request.getParameter("password");
		  DBUser user = new DBUser();
		  boolean isAdded = DBUser.addUser(name, pass);
		  DBUser.grantUserRole(name, "student");
		  if (isAdded) {
			 out.println("User added successfully");
		  } else {
			
%>


	<form method="post">
		Username: <input type="text" name="username"> <br />
		Password: <input type="password" name="password"> <br />
		Name: <input type="text" name="name"> <br /> E-mail: <input
			type="text" name="email"> <br /> <input type="submit">
		<br />
	</form>
</body>
</html>