<%@page import="com.finna.be.octo.avenger.core.db.model.DBUser"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.impl.UserDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.IUserDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.ITaskDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.model.DBProject"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.IProjectDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.impl.ProjectDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.impl.TaskDAO"%>
<%@page import="java.util.Collection"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.IProjectDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.impl.ProjectDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.model.DBProject"%>
<%@page import="com.finna.be.octo.avenger.core.db.model.DBTask"%>

<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		IProjectDAO projectDAO = new ProjectDAO();
		Collection<DBProject> projects = projectDAO.getProjects();
		IUserDAO userDAO = new UserDAO();
		List<DBUser> users = userDAO.getUsers();
	%>

	<form action="CreateTaskServlet" method="post">
	<label>Name</label>
	<input type="text"  name="name">
	<br/>
	<label>Description</label>
	<input type="text" name="description">
	<br>
	<label>Date</label>
	<input type="text" name="date">
	<br>
	
		<select name="project">
			<%
				for (DBProject project : projects) {
					out.write("<option value=" + project.getId() + ">"
							+ project.getName() + "</option>");
				}
			%>
		</select> <br>
		<select name="user">
		<%
				for (DBUser user : users) {
					out.write("<option value=" + user.getId() + ">"
							+ user.getUsername() + "</option>");
				}
			%>
		</select> 
		<input type="submit">
	</form>
</body>
</html>