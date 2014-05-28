<%@page import="com.finna.be.octo.avenger.core.db.model.DBUser"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.IUserDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.impl.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<body>
<%
	System.out.println(request.getServletContext().getRealPath(""));
%>
<form method="post" action="j_security_check">
	User name:<input type="text" name="j_username" /><br />
	Password: <input type="password" name="j_password" /><br />
	<input type="submit" value="Login" />
</form>

</body>
</html>
