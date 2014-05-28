<%@page import="com.finna.be.octo.avenger.core.db.model.DBProject" %>
<%@page import="com.finna.be.octo.avenger.core.db.dao.IProjectDAO" %>
<%@page import="com.finna.be.octo.avenger.core.db.dao.impl.ProjectDAO" %>
<%@page import="java.util.Collection" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects</title>
</head>
<body>
<%
	IProjectDAO projectDAO = new ProjectDAO();
	Collection<DBProject> projects = projectDAO.getProjects();
	for (DBProject project : projects) {
		out.print("<a href=\"tasks.jsp?projectId=" + project.getId() + "\">" +
				project.getName() + " </a><br/>");
	}
%>
</body>
</html>