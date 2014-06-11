<%@ page import="com.finna.be.octo.avenger.core.db.dao.IUserDAO" %>
<%@ page import="com.finna.be.octo.avenger.core.db.dao.impl.UserDAO" %>
<%@ page import="com.finna.be.octo.avenger.core.db.model.DBUser" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div style="text-align: center; width: 100%">
<div style="text-decoration: blink;">
	Task tracker
</div>
Hello, 
<%
String username = request.getRemoteUser();
IUserDAO userDAO = new UserDAO();
if (userDAO.getByUsername(username) == null) {
	response.sendRedirect("./updateProfile.jsp");
}
out.print(request.getRemoteUser());
%>!
<div>

	<a href='./DisplayProjects'>Projects</a> |
	<a href='./DisplayUsers'>Users</a> |
	<a href='./DisplayActions'>What is happaning</a> |
	<a href='./DisplaySubscriptions'> My subscribed tasks</a>
</div>
</div>